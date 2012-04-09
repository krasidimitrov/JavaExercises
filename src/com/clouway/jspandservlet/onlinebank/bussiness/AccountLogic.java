package com.clouway.jspandservlet.onlinebank.bussiness;

import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;
import com.clouway.jspandservlet.onlinebank.exceptions.InsufficientBalanceException;

import java.math.BigDecimal;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/29/12
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AccountLogic {


  /**
   * Register a new user to the data repository
   * @param userName the userName with which the user is going to be registered
   * @param password the password with which the user is going to be register
   * @throws IncorrectDataFormatException if the data used for the registration is in wrong format(length, forbidden symbols)
   * @throws DuplicateUserNameException if the user already exists in the data repository
   */
  public void register(String userName, String password) throws IncorrectDataFormatException, DuplicateUserNameException;

  /**
   * Decrease the total balance of an account
   * @param userName the userName for the account for which the total balance will be decreased
   * @param withdraw the amount with which the total balance will be decreased
   * @throws InsufficientBalanceException if there is not enough sum to withdraw from the account
   */
  public void withdraw(String userName, BigDecimal withdraw) throws InsufficientBalanceException;

  /**
   * Increase the total balance of an account
   * @param userName the userName for the account for which the total balance will be increased
   * @param deposit the amount with which the total balance will be increased
   */
  public void deposit(String userName, BigDecimal deposit);

  /**
   * Check if a password for a given user is correct
   * @param userName the userName for which we are going to check the password
   * @param password the password that we are going to check
   * @return true if this password is for this user and false otherwise
   */
  public boolean checkIfPasswordForTheUsernameIsCorrect(String userName, String password);

  //public BigDecimal getAccountBalance(String userName);

  /**
   * Return a BigDecimal from string if its format is correct
   * @param expression the string which is going to be the BigDecimal
   * @param limit the numbers of digits that a BigDecimal can have before the floating point (i.e. limit = 3  -> 357 or 435.12)
   * @return BigDecimal if the format of the string is correct
   * @throws IncorrectDataFormatException when the string cant be turned into BigDecimal or it exceed the limit of digits
   */
  public BigDecimal getBigDecimalIfFormatIsCorrect(String expression, int limit) throws IncorrectDataFormatException;
}
