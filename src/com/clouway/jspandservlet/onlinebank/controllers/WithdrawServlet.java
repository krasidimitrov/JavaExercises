package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseBankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper;

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
  private DatabaseHelper helper = new DatabaseHelper();
  private BankRepository bank = new DatabaseBankRepository(helper);
  private AccountLogic account = new AccountLogicImpl(bank);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String withdraw = req.getParameter("withdraw");

    HttpSession session = req.getSession();
    String userName = session.getAttribute("userName").toString();
    account.withdraw(userName, withdraw, 5);
    resp.sendRedirect("/war/onlinebank/userpage.jsp");

  }
}
