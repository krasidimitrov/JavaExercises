package com.clouway.networkingandgui.chatsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contains all the methods for the server part of the chat system
 * Created by Krasimir Dimitrov
 * Date: 12/1/11
 * Time: 1:43 PM
 */
public class ChatServer implements Runnable {
    private int port = 7777;
    private ServerSocket server = null;
    private Socket client = null;
    private ServerEventListener listener;

    public void addServerListener(ServerEventListener serverListener) {
        this.listener = serverListener;
    }

    /**
     * Start the server
     */
    public void startServer() {
        try {
            server = new ServerSocket(port);
            new Thread(this).start();
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
        }
    }

    /**
     * Listen for client
     */
    public void acceptClient() {
        try {
            client = server.accept();
        } catch (IOException e) {
            System.err.println("Accept Failed");
        }
    }

    /**
     * Stop the server
     */
    public void stopServer() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send message to the client
     */
    public void sendMessage() {
        PrintWriter out = null;

        try {
            out = new PrintWriter(client.getOutputStream(), true);

            out.println("Hello! Now is:" + getCurrentDateAndTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the current date and time
     *
     * @return the current date and tame as a string
     */
    public String getCurrentDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * Handle the activities in the client
     */
    public void run() {
        listener.onServerStart(new ServerEvent("Server Started"));
        acceptClient();
        //Throw exception wtf?
        if (client.isConnected()) {
            listener.onClientConnection(new ServerEvent("Client connected."));
            sendMessage();
            listener.onServerMessageSend(new ServerEvent("Message sent to client"));
        }
    }
}
