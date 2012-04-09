package com.clouway.jspandservlet.onlinebank.persistance;

import com.google.inject.Inject;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Used to make queries to the database
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/16/12
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseBankRepository implements BankRepository {
  private final DatabaseHelper databaseHelper;

  /**
   * Constructor
   * @param helper a DatabaseHelper object
   */
  @Inject
  public DatabaseBankRepository(DatabaseHelper helper){
    databaseHelper=helper;
  }

  /**
   * Save user to the database
   * @param userName the userName for the user that we are going to save
   * @param password the password for the user that w are going to save
   */
  public void saveUser(String userName, String password){
    databaseHelper.executeQuery("INSERT INTO Users VALUES(?,?,0);", userName ,password);
  }

  /**
   * Get userName from the database
   * @param userName which we want to select from the database;
   * @return  the userName  of a user if this user exist in the database
   */
  public String getUsername(String userName){
    return databaseHelper.executeQueryWithResult("SELECT userName FROM Users WHERE userName = ?;",userName);
  }

  /**
   * Get the passowrd for a user
   * @param userName the userName of the user for which we want to get the password
   * @return the password for the given userName
   */
  public String getPassword(String userName){
    return databaseHelper.executeQueryWithResult("SELECT password FROM Users WHERE userName = ?;",userName);
  }

  /**
   * Get the balance of a user form the database
   * @param userName the userName of the user for which we are going to get the balance
   * @return the balance for the user with the given userName
   */
  public BigDecimal getBalance(String userName){
    return new BigDecimal(databaseHelper.executeQueryWithResult("SELECT balance FROM Users WHERE userName = ?", userName));
  }

  /**
   * Update the balance of a user
   * @param userName the userName for the user for which we are going to update the balance
   * @param balance the new balance for the current user
   */
  public void updateBalance(String userName, BigDecimal balance){
    databaseHelper.executeQuery("UPDATE Users SET balance = ? WHERE userName = ?", balance, userName);
  }

  /**
   * Check if user exists in the database
   * @param userName the userName for which we want to check if such user exists
   * @return true if the user exists and false otherwise
   */
  public boolean checkIfUserNameExists(String userName){
    if(getUsername(userName).equals(userName)){
      return true;
    }
    return false;
  }
}
