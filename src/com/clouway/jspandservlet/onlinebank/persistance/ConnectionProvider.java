package com.clouway.jspandservlet.onlinebank.persistance;

import java.sql.Connection;

/**
* Created by Krasimir Dimitrov
* Email: krasimir.dimitrov@clouway.com.
* Date: 3/19/12
* Time: 11:08 AM
* To change this template use File | Settings | File Templates.
*/
public class ConnectionProvider implements Provider<Connection>{

  public Connection get() {

    return DatabaseConnectionFilter.connectionThreadLocal.get();
  }
}
