package com.clouway.jspandservlet.onlinebank;

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
public class LogoutServlet extends HttpServlet{
  DatabaseHelper databaseHelper = new DatabaseHelper();
  UsersOnlineRepository onlineUsers = new DatabaseUsersOnlineRepository(databaseHelper);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    try {
      onlineUsers.updateExpirationTime(session.getAttribute("userName").toString(), session.getAttribute("creationTime").toString(), 0);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    session.removeAttribute("userName");
    session.invalidate();
    resp.sendRedirect("/war/onlinebank/index.jsp");
  }
}
