package com.clouway.jspandservlet.onlinebank;

import com.clouway.jspandservlet.onlinebank.exceptions.DatabaseException;
import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;

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

  public AccountLogicImpl(BankRepository bankRepository) {
    bank = bankRepository;

  }

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

  public void withdraw(String userName, String withdraw) {
    int currentBalance;
    int newBalance;

    try {
      if (withdraw.matches("[0-9]{1,5}$")) {
        currentBalance = Integer.parseInt(bank.getBalance(userName));
        newBalance = currentBalance - Integer.parseInt(withdraw);
        if (newBalance >= 0) {
          bank.updateBalance(userName, newBalance);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deposit(String userName, String deposit) {
    String currentBalance;
    int newBalance;

    try {
      if (deposit.matches("[0-9]{1,5}$")) {
        currentBalance = bank.getBalance(userName);
        newBalance = Integer.parseInt(currentBalance) + Integer.parseInt(deposit);
        bank.updateBalance(userName, newBalance);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
} 
