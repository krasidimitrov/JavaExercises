package com.clouway.jspandservlet.onlinebank.controllers;

/**
* Created by Krasimir Dimitrov
* Email: krasimir.dimitrov@clouway.com.
* Date: 3/19/12
* Time: 11:53 AM
* To change this template use File | Settings | File Templates.
*/
public class UserSessions {

  private final Integer counter;

  public UserSessions(Integer counter) {
    this.counter = counter;
  }

  public Integer getCounter() {
    return counter;
  }
}
