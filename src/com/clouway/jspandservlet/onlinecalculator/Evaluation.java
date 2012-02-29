package com.clouway.jspandservlet.onlinecalculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/21/12
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Evaluation {
  private String[] operations = {"+", "-", "*", "/"};
  private Map<String, Operation> operationMap = new HashMap<String, Operation>();

  public Evaluation() {
    operationMap.put("*", new OperationMultiplication());
    operationMap.put("/", new OperationDivision());
    operationMap.put("+", new OperationAddition());
    operationMap.put("-", new OperationSubtraction());
  }

  public int eval(String expression) {
    String numbers[] = null;
    String operationSymbol = "";
    for (String operation : operations) {
      if (expression.contains(operation)) {
        operationSymbol = operation;
        numbers = expression.split("\\" + operation);
      }
    }

    if (numbers == null) {
      return Integer.parseInt(expression);
    } else if (numbers.length == 2) {
      return operationMap.get(operationSymbol).calculate(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
    } else {
      return Integer.parseInt(numbers[0]);
    }
  }

}
