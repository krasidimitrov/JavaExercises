package com.clouway.jspandservlet.onlinebank.bussiness;

import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/1/12
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsersOnlineHandlerImpl implements UsersOnlineHandler {

  private UsersOnlineRepository usersOnline;

  public UsersOnlineHandlerImpl(UsersOnlineRepository usersOnline) {
    this.usersOnline = usersOnline;
  }

  public void saveUserAsOnline(String userName, int sessionMaxInactiveInterval) {
    try {
      usersOnline.save(userName, sessionMaxInactiveInterval);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateOnlineTime(String userName, String timeOfLogin, int sessionInactiveInterval) {
    try {
      usersOnline.updateExpirationTime(userName, timeOfLogin, sessionInactiveInterval);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
