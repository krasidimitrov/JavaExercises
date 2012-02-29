package com.clouway.jspandservlet.onlinecalculator;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/25/11
 * Time: 4:08 PM
 */
public class OperationSubtraction implements Operation {

  /**
   * Subtract one number from another
   * @param num1 the number from which we are subtracting
   * @param num2 the number which we subtract
   * @return the resulf from the subtraction
   */
  public int calculate(int num1, int num2) {
    return num1 - num2;
  }
}