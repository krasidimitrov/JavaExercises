package com.clouway.testing.messageservice;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/7/11
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class MessageService {

    private final SmsGateway smsGateway;

    public MessageService(SmsGateway smsGateway) {
        this.smsGateway = smsGateway;
    }

    /**
     * send an Sms if all the requirement are met
     * @param smsMessage
     */
    public void sendSms(SmsMessage smsMessage) {
        if (smsMessage.getText().length() == 0)// || smsMessage.getTopic().length() == 0 || smsMessage.getNumber().length() == 0)
            throw new ThereIsAnEmptyFieldException();
        if (smsMessage.getText().length() > 20)
            throw new MessageToLongToBeSendException();

        smsGateway.sendSms(smsMessage);
    }


}
