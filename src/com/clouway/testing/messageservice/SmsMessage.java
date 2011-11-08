package com.clouway.testing.messageservice;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/7/11
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class SmsMessage {

    private final String topic;
    private final String text;
    private final String number;

    public SmsMessage(String topic, String text, String number) {
        this.topic = topic;
        this.text = text;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public String getTopic() {
        return topic;
    }


}
