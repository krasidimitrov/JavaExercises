package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;
import com.clouway.jspandservlet.onlinebank.exceptions.InsufficientBalanceException;
import com.clouway.jspandservlet.onlinebank.guice.DatabaseBankModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Handle the withdraw action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class WithdrawServlet extends HttpServlet {

  private Injector injector;
  private AccountLogic accountLogic;

  @Override
  public void init(ServletConfig config) throws ServletException {
    injector = Guice.createInjector(new DatabaseBankModule());
    accountLogic = injector.getInstance(AccountLogicImpl.class);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    BigDecimal withdraw;
    String message = "Withdraw successful!";
    HttpSession session = req.getSession();
    try {
      withdraw = accountLogic.getBigDecimalIfFormatIsCorrect(req.getParameter("withdraw"), 5);
      accountLogic.withdraw((String) session.getAttribute("userName"), withdraw);
    } catch (IncorrectDataFormatException e) {
      message = "Incorrect withdraw value! Try numbers only. Max 5 numbers";
    } catch (InsufficientBalanceException e) {
      message = "Not enough balance to complete the withdraw";
    }
    resp.sendRedirect(req.getContextPath() + "/onlinebank/userpage.jsp?message=" + message);
  }

}