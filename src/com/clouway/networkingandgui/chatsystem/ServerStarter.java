package com.clouway.networkingandgui.chatsystem;

/**
 * Used to start a new server
 * Created by Krasimir Dimitrov
 * Date: 12/9/11
 * Time: 5:41 PM
 */
public class ServerStarter {

    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI(new ChatServer());
    }
}
