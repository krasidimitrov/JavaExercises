package com.clouway.jspandservlet.onlinebank.persistance;

import java.sql.SQLException;
import java.sql.Time;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/24/12
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseUsersOnlineRepository implements UsersOnlineRepository {
  private DatabaseHelper databaseHelper;

  public DatabaseUsersOnlineRepository(DatabaseHelper helper) {
    databaseHelper = helper;
  }

  public void save(String userName, int timeLimit) throws SQLException {
    databaseHelper.executeQuery("INSERT INTO UsersOnline (userName, creationTime, expirationTime) VALUES (?, ?, ?);", userName, new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis() + timeLimit * 1000));
  }

  public void updateExpirationTime(String userName, String creationTime, int timeLimit) throws SQLException {
    databaseHelper.executeQuery("UPDATE UsersOnline SET expirationTime=? WHERE userName=? AND creationTime = ?;", new Time(System.currentTimeMillis()+timeLimit*1000), userName, creationTime);
  }
  
  public String getOnlineUsersCount() throws SQLException {
    return databaseHelper.executeQueryWithResult("SELECT COUNT(*) FROM UsersOnline WHERE expirationTime>?;", new Time(System.currentTimeMillis()));
  }
}
