package com.clouway.jspandservlet.onlinebank.bussiness;

import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;
import com.clouway.jspandservlet.onlinebank.exceptions.InsufficientBalanceException;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;
import com.google.inject.Inject;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/29/12
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountLogicImpl implements AccountLogic {
  private final BankRepository bank;

  @Inject
  public AccountLogicImpl(BankRepository bankRepository) {
    bank = bankRepository;
  }

  /**
   * Return a BigDecimal from string if its format is correct
   *
   * @param expression the string which is going to be the BigDecimal
   * @param limit the numbers of digits that a BigDecimal can have before the floating point (i.e. limit = 3  -> 357 or 435.12)
   * @return BigDecimal if the given string is in a correct format
   */
  public BigDecimal getBigDecimalIfFormatIsCorrect(String expression, int limit) {
    if (expression.matches("^[0-9]{1," + limit + "}\\.[0-9]{1,2}$|^[0-9]{1," + limit + "}$")) {
      return new BigDecimal(expression);
    } else {
      throw new IncorrectDataFormatException();
    }
  }

  /**
   * Register a new user to the data base
   *
   * @param userName the userName with which the user is going to be registered
   * @param password the password with which the user is going to be register
   */
  public void register(String userName, String password) {
    String checkName = "";
    if (userName.matches("^[A-Za-z0-9]{5,20}$") && password.matches("^[A-Za-z0-9]{5,20}$")) {
      checkName = bank.getUsername(userName);
      if (userName.equalsIgnoreCase(checkName)) {
        throw new DuplicateUserNameException();
      } else {
        bank.saveUser(userName, password);
      }
    } else {
      throw new IncorrectDataFormatException();
    }

  }

  /**
   * Decrease the total balance of an account
   *
   * @param userName the userName for the account for which the total balance will be decreased
   * @param withdraw the amount with which the total balance will be decreased
   */
  public void withdraw(String userName, BigDecimal withdraw) {

    BigDecimal newBalance;
    BigDecimal currentBalance;

    currentBalance = bank.getBalance(userName);
    newBalance = currentBalance.subtract(withdraw);
    if (newBalance.compareTo(new BigDecimal(0.00)) != -1) {
      bank.updateBalance(userName, newBalance);
    } else {
      throw new InsufficientBalanceException();
    }
  }

  /**
   * Increase the total balance of an account
   *
   * @param userName the userName for the account for which the total balance will be increased
   * @param deposit the amount with which the total balance will be increased
   */
  public void deposit(String userName, BigDecimal deposit) {
    BigDecimal currentBalance;
    BigDecimal newBalance;

    currentBalance = bank.getBalance(userName);
    newBalance = currentBalance.add(deposit);
    bank.updateBalance(userName, newBalance);
  }

  /**
   * Check if a given password match the password of a userName
   *
   * @param userName the userName for which we are going to check the password
   * @param password the password that we are going to check
   * @return true if the password matches and false if it doesn't
   */
  public boolean checkIfPasswordForTheUsernameIsCorrect(String userName, String password) {
    if (!password.equals(bank.getPassword(userName)) || userName.equals("")) {
      return false;
    }
    return true;
  }


}
