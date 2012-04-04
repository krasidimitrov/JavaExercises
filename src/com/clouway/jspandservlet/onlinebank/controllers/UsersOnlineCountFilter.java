package com.clouway.jspandservlet.onlinebank.controllers;

import com.clouway.jspandservlet.onlinebank.inject.Injector;
import com.clouway.jspandservlet.onlinebank.persistance.Provider;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;

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
import java.sql.SQLException;
import java.sql.SQLOutput;

/**
 * Used for showing the online users count
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/15/12
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsersOnlineCountFilter implements Filter {
  private UsersOnlineRepository usersOnline;

  public void init(FilterConfig filterConfig) throws ServletException {
    usersOnline = Injector.injectUsersOnlineRepository(Injector.injectHelper());
  }


  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpSession session = ((HttpServletRequest) servletRequest).getSession();
    if (session.getAttribute("userName") != null) {
      ((HttpServletResponse) servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/onlinebank/userpage.jsp");
    } else {
      usersOnline = Injector.injectUsersOnlineRepository(Injector.injectHelper());
      servletRequest.setAttribute("onlineUsersCount", usersOnline.getOnlineUsersCount());
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {

  }
}
