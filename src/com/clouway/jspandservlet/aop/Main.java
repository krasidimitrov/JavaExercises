package com.clouway.jspandservlet.aop;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class Main {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new OperationModule());
    Evaluator evaluator = injector.getInstance(Evaluator.class);

    System.out.println(evaluator.evaluate(4,"*",6));
  //  System.out.println(opAddition.calculate(4,2));
    //System.out.println(opAddition.calculate(3,3));
  }
}
