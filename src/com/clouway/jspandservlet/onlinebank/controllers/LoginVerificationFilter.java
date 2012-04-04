package com.clouway.jspandservlet.onlinebank.controllers;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Check if a user is logged in
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/15/12
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginVerificationFilter implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpSession session = ((HttpServletRequest) servletRequest).getSession();
    if (session.getAttribute("userName") == null) {
//      RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/onlinebank/index.jsp");
//      requestDispatcher.forward(servletRequest, servletResponse);
     ((HttpServletResponse) servletResponse).sendRedirect("/war/onlinebank/index.jsp");
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }

  public void destroy() {

  }
}
