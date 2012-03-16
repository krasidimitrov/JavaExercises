package com.clouway.jspandservlet.onlinebank.persistance;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Implement all methods from the BankRepository for a database
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/16/12
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseBankRepository implements BankRepository {
  private DatabaseHelper databaseHelper;

  /**
   * Constructor
   * @param helper a DatabaseHelper object
   */
  public DatabaseBankRepository(DatabaseHelper helper){
    databaseHelper=helper;
  }

  /**
   * Save user to the database
   * @param userName the userName for the user that we are going to save
   * @param password the password for the user that w are going to save
   * @throws SQLException
   */
  public void saveUser(String userName, String password) throws SQLException {
    databaseHelper.executeQuery("INSERT INTO Users VALUES(?,?,0);", userName ,password);
  }

  /**
   * Get userName from the database
   * @param userName
   * @return  the userName  of a user if this user exist in the database
   * @throws SQLException
   */
  public String getUsername(String userName) throws SQLException {
    return databaseHelper.executeQueryWithResult("SELECT userName FROM Users WHERE userName = ?;",userName);
  }

  /**
   * Get the passowrd for a user
   * @param userName the userName of the user for which we want to get the password
   * @return the password for the given userName
   * @throws SQLException
   */
  public String getPassword(String userName) throws SQLException {
    return databaseHelper.executeQueryWithResult("SELECT password FROM Users WHERE userName = ?;",userName);
  }

  /**
   * Get the balance of a user form the database
   * @param userName the userName of the user for which we are going to get the balance
   * @return the balance for the user with the given userName
   * @throws SQLException
   */
  public String getBalance(String userName) throws SQLException {
    return databaseHelper.executeQueryWithResult("SELECT balance FROM Users WHERE userName = ?", userName);
  }

  /**
   * Update the balance of a user
   * @param userName the userName for the user for which we are going to update the balance
   * @param balance the new balance for the current user
   * @throws SQLException
   */
  public void updateBalance(String userName, BigDecimal balance) throws SQLException {
    databaseHelper.executeQuery("UPDATE Users SET balance = ? WHERE userName = ?", balance, userName);
  }

  /**
   * Check if user exists in the database
   * @param userName the userName for which we want to check if such user exists
   * @return true if the user exists and false otherwise
   * @throws SQLException
   */
  public boolean checkIfUserNameExists(String userName) throws SQLException {
    if(getUsername(userName).equals(userName)){
      return true;
    }
    return false;
  }
}
