package com.clouway.jspandservlet.onlinecalculator;

/**
 * Interface for the operation classes
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/21/12
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Operation {
  /**
   * calculate an operation with two integer numbers
   * @param num1 the first number for the calculation
   * @param num2 the second number for the calculation
   * @return
   */
  public int calculate(int num1, int num2);
}
