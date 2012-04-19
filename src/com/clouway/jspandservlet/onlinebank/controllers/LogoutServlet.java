package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.clouway.jspandservlet.onlinebank.guice.DatabaseBankModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Used to log out a user from the system and make it offline in the database
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/24/12
 * Time: 4:59 PM
 */

@Singleton
public class LogoutServlet extends HttpServlet {

  private final UsersOnlineHandler usersOnline;

  @Inject
  public LogoutServlet(UsersOnlineHandler usersOnlineHandler){
    usersOnline = usersOnlineHandler;
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    usersOnline.updateOnlineTime(session.getAttribute("userName").toString(), session.getAttribute("creationTime").toString(), 0);

    session.removeAttribute("userName");
    session.invalidate();
    resp.sendRedirect(req.getContextPath() + "/onlinebank/index.jsp");
  }
}
