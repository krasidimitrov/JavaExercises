package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.ConnectionProvider;
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
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/24/12
 * Time: 4:59 PM
 */
public class LogoutServlet extends HttpServlet {
  private DatabaseHelper databaseHelper = new DatabaseHelper(new ConnectionProvider());
  private UsersOnlineRepository usersOnlineRepository = new DatabaseUsersOnlineRepository(databaseHelper);
  //this BankRepository is not used here so is it wrong to give a null parameter to UsersOnlineHandler instead bank?
  private BankRepository bank = new DatabaseBankRepository(databaseHelper);
  private UsersOnlineHandler usersOnline = new UsersOnlineHandlerImpl(usersOnlineRepository);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    usersOnline.updateOnlineTime(session.getAttribute("userName").toString(), session.getAttribute("creationTime").toString(), 0);

    session.removeAttribute("userName");
    session.invalidate();
    resp.sendRedirect("/war/onlinebank/index.jsp");
  }
}
