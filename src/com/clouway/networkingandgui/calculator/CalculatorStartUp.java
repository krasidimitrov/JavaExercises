package com.clouway.networkingandgui.calculator;

/**
 * Used to run the calculator
 * Created by Krasimir Dimitrov
 * Date: 11/28/11
 * Time: 5:10 PM
 */

public class CalculatorStartUp {
    public static void main(String[] args) {
        OperationHolder operationHolder = new OperationHolder();
        operationHolder.includeOperation("+", new OperationAddition());
        operationHolder.includeOperation("-", new OperationSubtraction());
        operationHolder.includeOperation("*", new OperationMultiplication());
        operationHolder.includeOperation("/", new OperationDivision());
        Calculator cal = new Calculator(operationHolder);
    }
}
