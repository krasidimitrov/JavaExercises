package com.clouway.networkingandgui.multiclientchatsystem.serverchat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The gui for the server part of the
 * Created by Krasimir Dimitrov
 * Date: 12/1/11
 * Time: 11:03 AM
 */
public class ServerGUI extends JFrame {

    private JTextArea messageShowArea;
    private JButton stopServerButton;
    private ChatServer server;
    //private JButton

    public ServerGUI(ChatServer chatServer) {
        super("Chat Server");
        this.server = chatServer;

        messageShowArea = new JTextArea();
        messageShowArea.setPreferredSize(new Dimension(450, 200));
        messageShowArea.setEditable(false);
        messageShowArea.setAutoscrolls(false);
        add(messageShowArea);

        stopServerButton = new JButton("START SERVER");
        add(stopServerButton);
        ServerHandler connectionHandler = new ServerHandler();
        stopServerButton.addActionListener(connectionHandler);

        //Custom listener used on new client connection
        chatServer.addServerListener(new ServerEventListener() {
            public void onClientConnection(ServerEvent event) {
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
     * Event handler for the start server button
     */
    private class ServerHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (stopServerButton.getText().equals("START SERVER")) {
                server.startServer();
                stopServerButton.setText("TERMINATE SERVER");
            } else {
                server.stopServer();
                System.exit(1);
                stopServerButton.setText("START SERVER");
            }
        }
    }
}
