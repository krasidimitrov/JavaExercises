package com.clouway.jspandservlet.onlinebank.persistance;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 *Define all basic methods for operating with a data source.
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/16/12
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BankRepository {
  /**
   * Save a user in the data source
   * @param userName the userName for the user that we are going to save
   * @param password the password for the user that w are going to save
   * @throws SQLException
   */
  public void saveUser(String userName, String password);

  /**
   * Update the balance of a user in the data source
   * @param userName the userName for the user for which we are going to update the balance
   * @param balance the new balance for the current user
   * @throws SQLException
   */
  public void updateBalance(String userName, BigDecimal balance);

  /**
   * Get the current balance for a user
   * @param userName the userName of the user for which we are going to get the balance
   * @return  the current balance for a user
   * @throws SQLException
   */
  public BigDecimal getBalance(String userName);

  /**
   * Get the userName of a user
   * @param userName
   * @return the userName  of a user if this user exist in the data source
   * @throws SQLException
   */
  public String getUsername(String userName);

  /**
   * Get the password of a user
   * @param userName the userName of the user for which we want to get the password
   * @return the password for the given userName
   * @throws SQLException
   */
  public String getPassword(String userName);
}
