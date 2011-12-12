package com.clouway.networkingandgui.chatsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    Socket server;
    private ClientEventListener listener;
    PrintWriter out = null;
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
        }
    }

    /**
     * Disconnect the client from the server
     */
    public void terminateConnection() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Receive a message from the server(The hello message)
     */
    public void receiveMessage() {
        connectToServer();
        String helloMessage = "";
        try {
            in = new BufferedReader(new InputStreamReader(server.getInputStream()));

            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run all the activities here
     */
    public void run() {
        String helloMessage = "";

        try {
            listener.onConnectionToTheServer(new ClientEvent("Connected to server"));
            helloMessage = in.readLine();
            listener.onMessageArrival(new ClientEvent(helloMessage));
            in.close();
            terminateConnection();
            listener.onClientDisconnect(new ClientEvent("Connection terminated"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
