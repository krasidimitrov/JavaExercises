package com.clouway.jspandservlet.onlinebank.persistance;

/**
* Created by Krasimir Dimitrov
* Email: krasimir.dimitrov@clouway.com.
* Date: 3/19/12
* Time: 11:08 AM
*/
public interface Provider<T> {
  T get();
}
