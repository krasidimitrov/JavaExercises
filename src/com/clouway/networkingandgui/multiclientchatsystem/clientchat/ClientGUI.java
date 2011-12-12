package com.clouway.networkingandgui.multiclientchatsystem.clientchat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The gui for the client part of the chat system
 * Created by Krasimir Dimitrov
 * Date: 12/1/11
 * Time: 11:29 AM
 */
public class ClientGUI extends JFrame {

    private JTextArea messageShowArea;
    private JTextField messageWriteTextField;
    private JButton connectToServerButton;
    private JButton sendMessageButton;
    private ChatClient client;

    public ClientGUI(ChatClient chatClient) {
        super("Chat Client");

        this.client = chatClient;

        connectToServerButton = new JButton("Connect");
        add(connectToServerButton);

        ClientConnectHandler clientConnectHandler = new ClientConnectHandler();
        connectToServerButton.addActionListener(clientConnectHandler);

        messageShowArea = new JTextArea();
        messageShowArea.setPreferredSize(new Dimension(450, 200));
        messageShowArea.setEditable(false);
        messageShowArea.setAutoscrolls(false);
        messageShowArea.setLineWrap(true);
        add(messageShowArea);

        messageWriteTextField = new JTextField();
        messageWriteTextField.setPreferredSize(new Dimension(370, 25));
        messageWriteTextField.setBorder(null);
        add(messageWriteTextField);

        sendMessageButton = new JButton("SEND");
        add(sendMessageButton);

        //Custom listener for incoming messages
        client.addClientListener(new ClientEventListener() {
            public void onMessageArrival(ClientEvent event) {
                messageShowArea.append("\n" + event.getText());
            }
        });

        //Listener for the close button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                //   client.terminateConnection();
                System.exit(0);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.getHSBColor(0, 0, 0));   //100, 200, 500 for the previous color
        setSize(500, 320);
        setVisible(true);
        setResizable(false);
    }

    /*
     * Event handler for the connect button
     */
    private class ClientConnectHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (connectToServerButton.getText().equals("Connect")) {
                connectToServerButton.setText("Disconnect");
                client.connectToServer();
                client.receiveMessage();
            } else {
                connectToServerButton.setText("Connect");
            }
        }
    }
}
