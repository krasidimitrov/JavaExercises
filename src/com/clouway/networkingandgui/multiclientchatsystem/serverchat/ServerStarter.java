package com.clouway.networkingandgui.multiclientchatsystem.serverchat;

/**
 * Used to start a new server
 * Created by Krasimir Dimitrov
 * Date: 12/9/11
 * Time: 6:04 PM
 */
public class ServerStarter {

    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI(new ChatServer());
    }
}
