package com.clouway.jspandservlet.onlinebookcatalog.persistance;

import com.clouway.jspandservlet.onlinebookcatalog.controllers.BookDatabaseConnectionFilter;

import java.sql.Connection;

/**
 * Provide connection to the database from the BookDatabaseConnectionFilter
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class ConnectionProvider implements Provider<Connection>{
  public Connection get() {
    return BookDatabaseConnectionFilter.connectionThreadLocal.get();
  }
}
