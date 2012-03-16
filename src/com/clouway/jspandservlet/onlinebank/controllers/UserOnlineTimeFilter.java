package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseUsersOnlineRepository;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Update the online time limit of a user after which the user avtomatically log out
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/15/12
 * Time: 10:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserOnlineTimeFilter implements Filter {
  private DatabaseHelper databaseHelper;
  private UsersOnlineRepository usersOnlineRepository;
  private UsersOnlineHandler onlineUsers;

  public void init(FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpSession session = ((HttpServletRequest) servletRequest).getSession();

    databaseHelper = new DatabaseHelper();
    usersOnlineRepository = new DatabaseUsersOnlineRepository(databaseHelper);
    onlineUsers = new UsersOnlineHandlerImpl(usersOnlineRepository);

    onlineUsers.updateOnlineTime(session.getAttribute("userName").toString(), session.getAttribute("creationTime").toString(), session.getMaxInactiveInterval());

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {

  }
}
