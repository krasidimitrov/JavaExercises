package com.clouway.jspandservlet.onlinebank.bussiness;

import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;

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
  private BankRepository bank;
  private UsersOnlineRepository usersOnline;

  public AccountLogicImpl(BankRepository bankRepository) {
    bank = bankRepository;
  }

  /**
   * Register a new user to the data base
   * @param userName the userName with which the user is going to be registered
   * @param password the password with which the user is going to be register
   */
  public void register(String userName, String password) {
    String checkName="";
    if (userName.matches("^[A-Za-z0-9]{5,20}$") && password.matches("^[A-Za-z0-9]{5,20}$")) {
      try {
        checkName = bank.getUsername(userName);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(userName.equalsIgnoreCase(checkName)){
        throw new DuplicateUserNameException();
      } else {
        try {
          bank.saveUser(userName,password);
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    } else {
      throw new IncorrectDataFormatException();
    }

  }

  /**
   * Decrease the total balance of an account
   * @param userName the userName for the account for which the total balance will be decreased
   * @param withdraw the amount with which the total balance will be decreased
   * @param limit the limit of the amount with which we can decrease the total balance
   */
  public void withdraw(String userName, BigDecimal withdraw) {
//
//    BigDecimal newBalance;
//    String regLimit = Integer.toString(limit);
////    MathContext mc = new MathContext(0);
////    mc = mc.DECIMAL32;
//    try {
//
//      BigDecimal currentBalance = bank.getBalance(userName);
//
//      if (customerAccountHasEnoughAmountToWithdraw(withdraw, currentBalance)) {
//
//      }
////      if (withdraw.matches("^[0-9]{1,"+regLimit+"}\\.[0-9]{1,2}$|^[0-9]{1,"+regLimit+"}$")) {
//        currentBalance = new BigDecimal(bank.getBalance(userName));
//        newBalance = currentBalance.subtract(new BigDecimal(withdraw));
//        if (newBalance.compareTo(new BigDecimal(0.00)) != -1) {
//          bank.updateBalance(userName, newBalance);
//        }
////      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
  }

  private boolean customerAccountHasEnoughAmountToWithdraw(BigDecimal withdraw, BigDecimal currentBalance) {
    return withdraw.compareTo(currentBalance) < 0;
  }

  /**
   * Increase the total balance of an account
   * @param userName the userName for the account for which the total balance will be increased
   * @param deposit the amount with which the total balance will be increased
   * @param limit the limit of the amount with which we can increase the total balance
   */
  public void deposit(String userName, String deposit, int limit) {
    BigDecimal currentBalance;
    BigDecimal newBalance;
    String regLimit = Integer.toString(limit);

    try {
      if (deposit.matches("^[0-9]{1,"+regLimit+"}\\.[0-9]{1,2}$|^[0-9]{1,"+regLimit+"}$")) {
        currentBalance = bank.getBalance(userName);
        newBalance = currentBalance.add(new BigDecimal(deposit));
        bank.updateBalance(userName, newBalance);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public boolean checkIfPasswordForTheUsernameIsCorrect(String userName, String password) {
    try {
      if (!password.equals(bank.getPassword(userName)) || userName.equals("")) {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return true;
  }


}
