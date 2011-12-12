package com.clouway.networkingandgui.chatsystem;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/8/11
 * Time: 5:40 PM
 */
public interface ServerEventListener {

    public void onServerStart(ServerEvent event);
    public void onClientConnection(ServerEvent event);
    public void onServerMessageSend(ServerEvent event);
}
