package com.clouway.testing.messageservice;

import com.sun.xml.internal.ws.wsdl.writer.document.Message;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/7/11
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class MessageServiceTest {

    Mockery context = new JUnit4Mockery();
    SmsGateway smsGateway;
    SmsMessage correctSms;

     private void sendSms(SmsMessage smsMessage) {
        new MessageService(smsGateway).sendSms(smsMessage);
    }

    @Before
    public void testableData() {

        smsGateway = context.mock(SmsGateway.class);
        correctSms = new SmsMessage("topic", "kjh", "0887002929");
    }

    @Test
    public void happyPath() {

        context.checking(new Expectations() {{
            oneOf(smsGateway).sendSms(correctSms);
        }});

     sendSms(correctSms);
    }

    @Test (expected = MessageToLongToBeSendException.class)
    public void longSmsCannotBeSend() {

        final SmsMessage longSms = new SmsMessage("topic", "012345678901234567890123456789", "0887002929");

        context.checking(new Expectations() {{
            oneOf(smsGateway).sendSms(longSms);
        }});

     sendSms(longSms);

    }

    @Test (expected = ThereIsAnEmptyFieldException.class)
    public void emptySmsCannotBeSend() {
        final SmsMessage emptyTextSms = new SmsMessage("topic", "", "0887002929");
        MessageService service = new MessageService(smsGateway);

        context.checking(new Expectations() {{
            oneOf(smsGateway).sendSms(emptyTextSms);
        }});

        sendSms(emptyTextSms);
    }


}
