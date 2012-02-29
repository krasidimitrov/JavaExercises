package com.clouway.jspandservlet.onlinebank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;

/**
 * Handle the login action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet{
  private DatabaseHelper helper = new DatabaseHelper();
  private BankRepository bank = new DatabaseBankRepository(helper);
  private UsersOnlineRepository onlineUsers = new DatabaseUsersOnlineRepository(helper);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("userName");
    String password = req.getParameter("password");
    HttpSession session= req.getSession();
    try {
      if(password.equals(bank.getPassword(userName)) && !userName.equals("")){
      session.setAttribute("userName",userName);
      session.setAttribute("creationTime", new Time(System.currentTimeMillis()));
      session.setAttribute("balance",bank.getBalance(userName));
      onlineUsers.save(userName, session.getMaxInactiveInterval());
      resp.sendRedirect("/war/onlinebank/userpage.jsp");
      } else {
        resp.sendRedirect("/war/onlinebank/index.jsp");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
