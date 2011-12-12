package com.clouway.networkingandgui.calculator;

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
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}
