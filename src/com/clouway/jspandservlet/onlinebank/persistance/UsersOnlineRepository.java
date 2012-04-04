package com.clouway.jspandservlet.onlinebank.persistance;

import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/24/12
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UsersOnlineRepository {

  public void save(String userName, int timeLimit);

  public void updateExpirationTime(String userName, String creationTime, int timeLimit);

  public String getOnlineUsersCount();
}
