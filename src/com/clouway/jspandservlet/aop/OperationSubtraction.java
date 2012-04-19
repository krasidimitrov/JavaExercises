package com.clouway.jspandservlet.aop;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class OperationSubtraction implements Operation{

  public int calculate(int a, int b) {
    return a-b;
  }
}
