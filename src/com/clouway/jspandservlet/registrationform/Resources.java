package com.clouway.jspandservlet.registrationform;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/20/12
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Resources {
  private String[] methods = new String[7];
  private String[] attributes = {"firstName", "lastName", "egn", "address", "userName", "password", "confirmPassword"};
  private String[] messages = new String[7];

  public Resources() {
    methods[0] = "validateName";
    methods[1] = "validateName";
    methods[2] = "validateEgn";
    methods[3] = "validateAddress";
    methods[4] = "validateUserName";
    methods[5] = "validatePassword";
    methods[6] = "confirmPassword";


    messages[0] = "First name must be 1-20 symbols only letters!";
    messages[1] = "Last name must be 1-20 symbols only letters!";
    messages[2] = "EGN must be exactly 10 numbers";
    messages[3] = "Address must 1-100 symbols";
    messages[4] = "User name must be 5-20 symbols letters and/or numbers!";
    messages[5] = "Password myst be 5-20 symblos letters and/or numbers!";
    messages[6] = "Password doesn't match";
  }

  public String[] getMethods() {
    return methods;
  }

  public String[] getAttributes() {
    return attributes;
  }

  public String[] getMessages() {
    return messages;
  }
}
