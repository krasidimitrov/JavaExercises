package com.clouway.networkingandgui.multiclientchatsystem.serverchat;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/8/11
 * Time: 5:41 PM
 */
public class ServerEvent {

    private String text;

    public ServerEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
