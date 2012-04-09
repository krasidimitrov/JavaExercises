package com.clouway.jspandservlet.onlinebank.persistance;

import java.sql.Connection;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 *         To change this template use File | Settings | File Templates.
 */
public interface TransactionExecutor {
  public void execute(Connection connection);
}
