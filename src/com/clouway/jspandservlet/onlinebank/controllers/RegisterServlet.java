package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseBankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper;
import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
  private AccountLogic account = new AccountLogicImpl(bank);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = req.getParameter("userName");
    String password = req.getParameter("password");
    session.setAttribute("errorMessage","");
    try{
      account.register(userName, password);
    } catch (DuplicateUserNameException e){
      session.setAttribute("errorMessage","Username already exists. Pls choose another!");
    } catch (IncorrectDataFormatException e){
      session.setAttribute("errorMessage","Username and password must be between 5 and 20 symbols. Only letters and numbers!");
    }
    if(!session.getAttribute("errorMessage").equals("")){
      resp.sendRedirect("/war/onlinebank/register.jsp");
      return;
    }
    resp.sendRedirect("/war/onlinebank/index.jsp");

  }
}
