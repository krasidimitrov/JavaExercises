package com.clouway.jspandservlet.onlinebank;

import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/29/12
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AccountLogic {
  
  public void register(String userName, String password) throws IncorrectDataFormatException, DuplicateUserNameException;

  public void withdraw(String userName, String withdraw);
  
  public void deposit(String userName, String deposit);

}
