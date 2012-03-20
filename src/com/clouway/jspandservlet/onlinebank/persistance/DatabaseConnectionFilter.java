package com.clouway.jspandservlet.onlinebank.persistance;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/19/12
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseConnectionFilter implements Filter {


  private MysqlDataSource dataSource;

  public void init(FilterConfig filterConfig) throws ServletException {
    dataSource = new MysqlDataSource();
    dataSource.setServerName("localhost");
    dataSource.setDatabaseName("BankDatabase");
    dataSource.setUser("kpackapgo");
    dataSource.setPassword("");
  }

  public static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    try {
      Connection connection = dataSource.getConnection();
      connectionThreadLocal.set(connection);
    } catch (SQLException e) {
      // handle error
      HttpServletResponse response = (HttpServletResponse) servletResponse;
      response.sendRedirect("/errorPage.jsp?error=Database Was Not Found");
      return;

    }


    // open connection

    filterChain.doFilter(servletRequest, servletResponse);

    Connection existingConnection = connectionThreadLocal.get();
    if (existingConnection != null) {
      try {
        existingConnection.close();
      } catch (SQLException e) {
        // handle error !!!
      }
    }
    // close connection
  }

  public void destroy() {

  }
}
