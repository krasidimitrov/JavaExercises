package com.clouway.jspandservlet.onlinebank;

import com.clouway.jspandservlet.onlinebank.exceptions.DatabaseException;
import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Handle the register action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServlet extends HttpServlet {
  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private BankRepository bank = new DatabaseBankRepository(databaseHelper);
  AccountLogic account = new AccountLogicImpl(bank);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("userName");
    String password = req.getParameter("password");

    try{
      account.register(userName, password);
    } catch (IncorrectDataFormatException e){
      //handle the exception
    } catch (DuplicateUserNameException e){
      //handle the exception
    }
    resp.sendRedirect("/war/onlinebank/index.jsp");

  }
}
