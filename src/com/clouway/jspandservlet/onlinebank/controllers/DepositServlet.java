package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;
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
import java.math.BigDecimal;

/**
 * Handle the deposit action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */

@Singleton
public class DepositServlet extends HttpServlet {

  private final AccountLogic account;

  @Inject
  public DepositServlet(AccountLogic accountLogic){
    account = accountLogic;
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    BigDecimal deposit;
    String message = "Deposit successful!";
    HttpSession session = req.getSession();
    //String userName = session.getAttribute("userName").toString();
    try {
      deposit = account.getBigDecimalIfFormatIsCorrect(req.getParameter("deposit"), 5);
      account.deposit((String) session.getAttribute("userName"), deposit);
    } catch (IncorrectDataFormatException e) {
      message = "Incorrect deposit value! Try numbers only. Max 5 numbers";
    }
    resp.sendRedirect(req.getContextPath() + "/onlinebank/userpage.jsp?message=" + message);

  }
}
