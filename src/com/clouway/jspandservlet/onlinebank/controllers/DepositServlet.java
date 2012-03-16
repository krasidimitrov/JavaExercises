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

/**
 * Handle the deposit action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class DepositServlet extends HttpServlet {
  private DatabaseHelper helper = new DatabaseHelper();
  private BankRepository bank = new DatabaseBankRepository(helper);
  private AccountLogic account = new AccountLogicImpl(bank);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String deposit = req.getParameter("deposit");

    HttpSession session = req.getSession();
    String userName = session.getAttribute("userName").toString();
    String currentBalance;
    int newBalance;

    account.deposit(userName,deposit,5);
    resp.sendRedirect("/war/onlinebank/userpage.jsp");

  }
}
