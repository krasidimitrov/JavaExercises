package com.clouway.networkingandgui.chatsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The gui for the server part of the chat system
 * Created by Krasimir Dimitrov
 * Date: 12/1/11
 * Time: 11:03 AM
 */
public class ServerGUI extends JFrame {

    private JTextArea messageShowArea;
    private JButton stopServerButton;
    private ChatServer chatServer;

    public ServerGUI(ChatServer server) {
        super("Chat Server");
        this.chatServer = server;

        messageShowArea = new JTextArea();
        messageShowArea.setPreferredSize(new Dimension(450, 200));
        messageShowArea.setEditable(false);
        messageShowArea.setAutoscrolls(false);
        add(messageShowArea);

        stopServerButton = new JButton("START SERVER");
        add(stopServerButton);
        ServerHandler connectionHandler = new ServerHandler();
        stopServerButton.addActionListener(connectionHandler);

        //Adding a custom listner for server events
        chatServer.addServerListener(new ServerEventListener() {
            public void onServerStart(ServerEvent event) {
                messageShowArea.append("\n" + event.getText());
            }

            public void onClientConnection(ServerEvent event) {
                messageShowArea.append("\n" + event.getText());
            }

            public void onServerMessageSend(ServerEvent event) {
                messageShowArea.append("\n" + event.getText());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.getHSBColor(0, 0, 0));   //100, 200, 500 for the previous color
        setSize(500, 300);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Event handler for the server start button
     */
    private class ServerHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (stopServerButton.getText().equals("START SERVER")) {
                stopServerButton.setText("TERMINATE SERVER");
                chatServer.startServer();
            } else {
                chatServer.stopServer();
                stopServerButton.setText("START SERVER");
            }
        }
    }
}
