package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.inject.Injector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
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

  private AccountLogic accountLogic;

  public WithdrawServlet() {
    accountLogic = Injector.injectAccountLogic();


  }
  
  interface RequestHandler {

    void handle(MyRequest request, HttpServletResponse response, HttpSession session);

  }

  class WithdrawHandler implements RequestHandler {

    public void handle(MyRequest request, HttpServletResponse response, HttpSession session) {

    }

  }

  protected WithdrawServlet(AccountLogic accountLogic) {
    this.accountLogic = accountLogic;
  }

  @Override
  public void init(ServletConfig config) throws ServletException {

  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    handle(new MyRequestImpl(req), resp);
  }
  


  protected void handle(MyRequest request, HttpServletResponse resp) throws IOException {


//    if (withdraw.matches("(\\d+\\.\\d{0,2}+)")) {
    try {
      BigDecimal withdrawAmount = request.getValue("withdraw");

      HttpSession session = request.getSession();
      String userName = (String) session.getAttribute("userName");

      accountLogic.withdraw(userName, withdrawAmount);

      resp.sendRedirect("/war/onlinebank/userpage.jsp");

    }catch (IllegalStateException e) {
      // set error and dispatch to the error page
    }

//    } else {
//      req.setAttribute("error", "Withdraw amount was not valid decimal value");
//
//      //TODO:  forward to proper error page
//      req.getRequestDispatcher("").forward(req, resp);
//    }
  }
}
