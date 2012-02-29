package com.clouway.jspandservlet.onlinecalculator;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/25/11
 * Time: 9:41 AM
 */
public class OperationAddition implements Operation {

  /**
   * Sum two numbers
   * @param num1 the first number that we are going to sum
   * @param num2 the second number that we are going to sum
   * @return the sum of the two numbers
   */
  public int calculate(int num1, int num2) {
    return num1 + num2;
  }
}