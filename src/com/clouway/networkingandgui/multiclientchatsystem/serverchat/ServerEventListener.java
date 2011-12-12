package com.clouway.networkingandgui.multiclientchatsystem.serverchat;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/8/11
 * Time: 5:40 PM
 */
public interface ServerEventListener {

    public void onClientConnection(ServerEvent event);
}
