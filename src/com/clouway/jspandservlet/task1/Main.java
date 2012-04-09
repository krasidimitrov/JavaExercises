package com.clouway.jspandservlet.task1;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class Main {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new FirstModule());

    TopClass topClass = injector.getInstance(TopClass.class);

    topClass.printWho();
  }
}
