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
  private Provider<UserSessions> userSessionsProvider; // It was final. I made it not final so i can inject it

  public void init(FilterConfig filterConfig) throws ServletException {
  usersOnline = Injector.injectUsersOnlineRepository(Injector.injectHelper());
  }

//  Without constructor
//  public UsersOnlineCountFilter(Provider<UserSessions> userSessionsProvider) {
//    this.userSessionsProvider = userSessionsProvider;
//  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpSession session = ((HttpServletRequest) servletRequest).getSession();
    if (session.getAttribute("userName") != null) {
      ((HttpServletResponse) servletResponse).sendRedirect("/war/onlinebank/userpage.jsp");
    }
    usersOnline = Injector.injectUsersOnlineRepository(Injector.injectHelper());
  //  userSessionsProvider = Injector.injectUserSessionProvider(session); // written by me
    try {
    //  session.setAttribute("onlineUsersCount",usersOnline.getOnlineUsersCount());

    //  UserSessions sessions = userSessionsProvider.get();
      //servletRequest.setAttribute("onlineUsersCount", sessions);
      servletRequest.setAttribute("onlineUsersCount", usersOnline.getOnlineUsersCount());
      servletRequest.getRequestDispatcher("onlinebank/index.jsp").forward(servletRequest, servletResponse);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {
    
  }
}
