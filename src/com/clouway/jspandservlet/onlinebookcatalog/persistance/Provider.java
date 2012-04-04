package com.clouway.jspandservlet.onlinebookcatalog.persistance;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public interface Provider<T> {
  T get();
}
