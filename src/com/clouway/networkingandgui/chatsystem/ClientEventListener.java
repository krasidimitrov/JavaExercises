package com.clouway.networkingandgui.chatsystem;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/8/11
 * Time: 4:03 PM
 */
public interface ClientEventListener {

    public void onConnectionToTheServer(ClientEvent event);
    public void onMessageArrival(ClientEvent event);
    public void onClientDisconnect(ClientEvent event);
}
