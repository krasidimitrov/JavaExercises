package com.clouway.jspandservlet.onlinebank;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/24/12
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class SessionCounter {
  DatabaseHelper databaseHelper;

  public SessionCounter(DatabaseHelper helper){
    databaseHelper = helper;
  }
}
