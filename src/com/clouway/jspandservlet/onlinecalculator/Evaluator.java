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
public class Evaluator {
  private String[] operations = {"+", "-", "*", "/"};
  private Map<String, Operation> operationMap = new HashMap<String, Operation>();

  public Evaluator() {
    operationMap.put("+", new OperationAddition());
    operationMap.put("-", new OperationSubtraction());
    operationMap.put("*", new OperationMultiplication());
    operationMap.put("/", new OperationDivision());
  }

  public int eval(String expression) {
    int num1;
    int num2;
    for(String operation: operations){
      if(expression.lastIndexOf(operation) > 0 ){//&& expression.lastIndexOf(operation) < expression.length()-1){
        try{
      num1 = Integer.parseInt(expression.substring(0, expression.lastIndexOf(operation)));
      num2 = Integer.parseInt(expression.substring(expression.lastIndexOf(operation)+1, expression.length()));
      return operationMap.get(operation).calculate(num1,num2);
        } catch (NumberFormatException e){
           throw new InvalidExpressionException();
        }
      }
    }
    return Integer.parseInt(expression);

//    int result = 0;
//    for (String sign : operations) {
//      if (expression.contains(sign)) {
//        try {
//          int firstNumber = Integer.parseInt(expression.substring(0, expression.lastIndexOf(sign)));
//          int secondNumber = Integer.parseInt(expression.substring(expression.lastIndexOf(sign) + 1, expression.length()));
//          result = operationMap.get(sign).calculate(firstNumber, secondNumber);
//        } catch (NumberFormatException exception) {
//        }
//      }
//    }
//    return result;
  }

}
