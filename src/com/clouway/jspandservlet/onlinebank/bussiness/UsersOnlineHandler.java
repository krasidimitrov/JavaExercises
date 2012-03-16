package com.clouway.jspandservlet.onlinebank.bussiness;

import java.math.BigDecimal;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/1/12
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UsersOnlineHandler {

  /**
   * Save user in a datasource when he became online
   * @param userName the userName for the user we are going to save
   * @param sessionMaxInactiveInterval the max inactive time after a user automatically go offline
   */
  public void saveUserAsOnline(String userName, int sessionMaxInactiveInterval);

  /**
   * Update the end time after a user will go automatically offline
   * @param userName the userName for which we are going to update the end timke
   * @param timeOfLogin
   * @param SessionInactiveInterval
   */
  public void updateOnlineTime(String userName, String timeOfLogin, int SessionInactiveInterval);

}
