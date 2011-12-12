package com.clouway.networkingandgui.chatsystem;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/8/11
 * Time: 4:03 PM
 */
public class ClientEvent {

    private String text;

    public ClientEvent(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
