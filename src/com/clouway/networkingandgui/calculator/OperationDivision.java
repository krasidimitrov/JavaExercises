package com.clouway.networkingandgui.calculator;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/25/11
 * Time: 4:09 PM
 */
public class OperationDivision implements Operation {

    /**
     * Diviide one number to another
     * @param num1 the number that we are going to divide
     * @param num2 the divider
     * @return  the result from the division
     */
    public double calculate(double num1, double num2) {
        return num1 / num2;
    }
}
