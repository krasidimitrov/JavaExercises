package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.clouway.jspandservlet.onlinebank.inject.Injector;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseBankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseUsersOnlineRepository;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;

/**
 * Handle the login action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {

  private AccountLogic account = Injector.injectAccountLogic();
  private UsersOnlineHandler usersOnline = Injector.injectUsersOnlineHandler();

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("userName");
    String password = req.getParameter("password");
    HttpSession session = req.getSession();
    if (account.checkIfPasswordForTheUsernameIsCorrect(userName, password) && !password.equals("")) {
      session.setAttribute("userName", userName);
      session.setAttribute("creationTime", new Time(System.currentTimeMillis()));
      usersOnline.saveUserAsOnline(userName, session.getMaxInactiveInterval());
      resp.sendRedirect(req.getContextPath() + "/onlinebank/userpage.jsp");
    } else {
      resp.sendRedirect(req.getContextPath() + "/onlinebank/index.jsp?errorMessage=Wrong username and/or password");
//     return;
    }

  }

}
