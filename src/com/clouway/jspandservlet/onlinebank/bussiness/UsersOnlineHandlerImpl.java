package com.clouway.jspandservlet.onlinebank.bussiness;

import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;


/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/1/12
 * Time: 3:03 PM
 */
public class UsersOnlineHandlerImpl implements UsersOnlineHandler {

  private UsersOnlineRepository usersOnline;

  public UsersOnlineHandlerImpl(UsersOnlineRepository usersOnline) {
    this.usersOnline = usersOnline;
  }

  /**
   * Save a user in a database when he login in the system
   *
   * @param userName the userName for the user we are going to save
   * @param sessionMaxInactiveInterval the max inactive time after a user automatically go offline
   */
  public void saveUserAsOnline(String userName, int sessionMaxInactiveInterval) {
    usersOnline.save(userName, sessionMaxInactiveInterval);
  }

  /**
   * Update the time at which the user will get automatically logged out
   *
   * @param userName the userName for which we are going to update the end time
   * @param timeOfLogin the time in which a user logged in the system
   * @param sessionInactiveInterval
   */
  public void updateOnlineTime(String userName, String timeOfLogin, int sessionInactiveInterval) {
    usersOnline.updateExpirationTime(userName, timeOfLogin, sessionInactiveInterval);
  }
}
