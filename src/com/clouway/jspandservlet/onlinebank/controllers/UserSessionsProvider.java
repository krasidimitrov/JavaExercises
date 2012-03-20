package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.persistance.Provider;

import javax.servlet.http.HttpSession;

/**
* Created by Krasimir Dimitrov
* Email: krasimir.dimitrov@clouway.com.
* Date: 3/19/12
* Time: 11:54 AM
* To change this template use File | Settings | File Templates.
*/
public class UserSessionsProvider implements Provider<UserSessions> {

  private final HttpSession session;

  public UserSessionsProvider(HttpSession session) {

    this.session = session;
  }

  public UserSessions get() {
    return new UserSessions(Integer.valueOf((String) session.getAttribute("sessionsCounter")));
  }
}
