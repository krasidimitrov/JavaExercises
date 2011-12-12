package com.clouway.networkingandgui.multiclientchatsystem.clientchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Contains all the methods for the client part of the chat system
 * Created by Krasimir Dimitrov
 * Date: 12/1/11
 * Time: 2:01 PM
 */
public class ChatClient implements Runnable {

    private int port = 7777;
    private String host = "localhost";
    private Socket server;
    private ClientEventListener listener;
    BufferedReader in;

    /**
     * Add a ClientEventListener to the chat client gui;
     *
     * @param clientListener the listener that we are going to add
     */
    public void addClientListener(ClientEventListener clientListener) {
        this.listener = clientListener;
    }

    /**
     * Connect to the server
     */
    public void connectToServer() {
        try {
            server = new Socket(host, port);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    /**
     * Disconnect from the server
     */
    public void terminateConnection() {
        try {
            server.shutdownOutput();
            server.shutdownInput();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Receive message from the server
     */
    public void receiveMessage() {
        try {
            in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Listening for messages here
    public void run() {
        listenForMessage();

    }

    /**
     * Listen for messages from the server and write them in the chat client using the client listener
     */
    private void listenForMessage() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println(message);
                listener.onMessageArrival(new ClientEvent(message));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
