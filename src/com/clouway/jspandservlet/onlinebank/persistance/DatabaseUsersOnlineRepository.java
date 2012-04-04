package com.clouway.jspandservlet.onlinebank.persistance;

import java.sql.SQLException;
import java.sql.Time;

/**
 * Used to make queries to the database
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

  /**
   * Save into the the UsersOnline table
   * @param userName the userName which we are going to save
   * @param timeLimit the time for which he will be online
   */
  public void save(String userName, int timeLimit) {
    databaseHelper.executeQuery("INSERT INTO UsersOnline (userName, creationTime, expirationTime) VALUES (?, ?, ?);", userName, new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis() + timeLimit * 1000));
  }

  /**
   * Update the expiration time of an online user after which he become offline
   * @param userName the userName of the user for which we are going to update the expiration time
   * @param creationTime the time at which the user became online
   * @param timeLimit the expiration time of the session
   */
  public void updateExpirationTime(String userName, String creationTime, int timeLimit){
    databaseHelper.executeQuery("UPDATE UsersOnline SET expirationTime=? WHERE userName=? AND creationTime = ?;", new Time(System.currentTimeMillis()+timeLimit*1000), userName, creationTime);
  }

  /**
   * Get all users from the database that are online at the moment
   * @return the count of all online users as a string
   */
  public String getOnlineUsersCount() {
    return databaseHelper.executeQueryWithResult("SELECT COUNT(*) FROM UsersOnline WHERE expirationTime>?;", new Time(System.currentTimeMillis()));
  }
}
