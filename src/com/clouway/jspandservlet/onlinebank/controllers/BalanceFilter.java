package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.clouway.jspandservlet.onlinebank.guice.DatabaseBankModule;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.ConnectionProvider;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseBankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseUsersOnlineRepository;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Used for showing the balance of a user
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/5/12
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */

@Singleton
public class BalanceFilter implements Filter {

  private final BankRepository bank;

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Inject
  public BalanceFilter(BankRepository bankRepository){
    bank = bankRepository;
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpSession session = request.getSession();
    request.setAttribute("balance", bank.getBalance((String) session.getAttribute("userName")));

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {
  }
}
