package com.clouway.networkingandgui.multiclientchatsystem.clientchat;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/8/11
 * Time: 4:03 PM
 */
public interface ClientEventListener {

    public void onMessageArrival(ClientEvent event);
}
