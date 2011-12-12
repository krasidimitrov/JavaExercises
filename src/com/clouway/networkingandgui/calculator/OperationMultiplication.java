package com.clouway.networkingandgui.calculator;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/25/11
 * Time: 4:09 PM
 */
public class OperationMultiplication implements Operation {

    /**
     * Find the product of two numbers
     * @param num1 the first of two numbers for which we are searching the product
     * @param num2 the second of two numbers for which we are searching the product
     * @return  the product of the two numbers
     */
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}
