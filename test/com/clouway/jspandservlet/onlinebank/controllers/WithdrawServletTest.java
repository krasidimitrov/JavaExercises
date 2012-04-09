//package com.clouway.jspandservlet.onlinebank.controllers;
//
//import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
//import org.jmock.Expectations;
//import org.jmock.Mockery;
//import org.jmock.integration.junit4.JMock;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.math.BigDecimal;
//
///**
//* Created by Krasimir Dimitrov
//* Email: krasimir.dimitrov@clouway.com.
//* Date: 3/19/12
//* Time: 11:34 AM
//* To change this template use File | Settings | File Templates.
//*/
//@RunWith(JMock.class)
//public class WithdrawServletTest {
//
//
//  Mockery context = new Mockery();
//
//  @Test
//  public void withdrawAmount() throws IOException, ServletException {
//    final AccountLogic accountLogic = context.mock(AccountLogic.class);
//    final MyRequest request = context.mock(MyRequest.class);
//    final HttpServletResponse response = context.mock(HttpServletResponse.class);
//    final HttpSession session = context.mock(HttpSession.class);
//
//    final BigDecimal amount = new BigDecimal(10d);
//    final String currentUser = "myuser";
//
//    context.checking(new Expectations() {{
//      oneOf(request).getValue("withdraw");
//      will(returnValue(amount));
//
//      oneOf(request).getSession();
//      will(returnValue(session));
//
//      oneOf(session).getAttribute("userName");
//      will(returnValue(currentUser));
//
//      oneOf(accountLogic).withdraw(currentUser, amount, 5);
//
//      oneOf(response).sendRedirect("/war/onlinebank/userpage.jsp");
//    }});
//
//   // WithdrawServlet servlet = new WithdrawServlet(accountLogic);
//    WithdrawServlet servlet = new WithdrawServlet();
//
//    servlet.handle(request, response);
//
//  }
//
//  @Test
//  public void withdrawOfInvalidAmountIsNotAllowed() {
//
//  }
//
//  @Test
//  public void amountWithSignsIsNotAllowed() {
//
//  }
//
//}
