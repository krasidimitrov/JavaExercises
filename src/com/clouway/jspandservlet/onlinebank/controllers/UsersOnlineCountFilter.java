package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.guice.DatabaseBankModule;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Used for showing the online users count
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/15/12
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */

@Singleton
public class UsersOnlineCountFilter implements Filter {
  
  private final UsersOnlineRepository usersOnline;

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Inject
  public UsersOnlineCountFilter(UsersOnlineRepository usersOnlineRepository){
    usersOnline = usersOnlineRepository;
  }


  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpSession session = ((HttpServletRequest) servletRequest).getSession();
    if (session.getAttribute("userName") != null) {
      ((HttpServletResponse) servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/onlinebank/userpage.jsp");
    } else {
      servletRequest.setAttribute("onlineUsersCount", usersOnline.getOnlineUsersCount());
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {

  }
}
