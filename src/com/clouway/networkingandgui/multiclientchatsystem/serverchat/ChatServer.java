package com.clouway.networkingandgui.multiclientchatsystem.serverchat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
    private int clientID = 0;
    private List<Socket> listOfClients = new ArrayList<Socket>();
    private ServerEventListener listener;

    /**
     * Add an event listener to the server
     *
     * @param serverListener the listener that we are going to add
     */
    public void addServerListener(ServerEventListener serverListener) {
        this.listener = serverListener;
    }

    /**
     * Start the server
     */
    public void startServer() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            new Thread(this).start();
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(1);
        }
    }

//    public synchronized void deleteClient() {
//      for(int i =0; i<listOfClients.size(); i++){
//          if(listOfClients.get(i).isClosed()){
//              System.out.println("Client "+i + " is gone");
//          }
//      }
//    }

    /**
     * Listen for clients who want to connect
     */
    public void acceptClient() {
        while (true) {
            try {
                //  deleteClient();
                client = server.accept();
                listener.onClientConnection(new ServerEvent("New Client connected"));
                clientID++;


            } catch (IOException e) {
                System.err.println("Accept Failed");
                System.exit(1);
            }
            Thread thread = new Thread(new ClientHandler(listOfClients));
            thread.start();

            listOfClients.add(client);
        }
    }

    /**
     * Send a message to all the clients
     */
    public synchronized void sendToAll() {
        PrintWriter out;
        //   for (Socket listOfClient : listOfClients) {
        for (int i = 0; i < listOfClients.size() - 1; i++) {
            try {
                out = new PrintWriter(listOfClients.get(i).getOutputStream(), true);
                out.println("Client with id " + clientID + " connected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Listening for clients is done here
    public void run() {
        acceptClient();
    }

    /**
     * A runnable used to send messages to all the clients when a new client is connected
     */
    private class ClientHandler implements Runnable {

        private List<Socket> clientsList;

        public ClientHandler(List<Socket> list) {
            this.clientsList = list;
        }

        public void run() {
            for (int i = 0; i < listOfClients.size(); i++) {
                if (!listOfClients.get(i).isConnected()) {
                    System.out.println("Client has disconnected");
                }
            }
            sendToAll();
        }
    }
}
