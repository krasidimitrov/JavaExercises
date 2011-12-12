package com.clouway.networkingandgui.multiclientchatsystem.clientchat;

/**
 * Used to start a new client
 * Created by Krasimir Dimitrov
 * Date: 12/9/11
 * Time: 5:50 PM
 */
public class ClientStarter {

    public static void main(String[] args) {
        ClientGUI serverGUI = new ClientGUI(new ChatClient());
    }
}
