package com.clouway.jspandservlet.aop;

import com.google.inject.Inject;

import java.util.Map;
import java.util.Set;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class Evaluator {

  private final Map<String, Operation> operationMap;

  @Inject
  public Evaluator(Map<String,Operation> operationMap){
    this.operationMap = operationMap;
  }

  public int evaluate(int a, String action, int b)
  {
    return operationMap.get(action).calculate(a,b);
  }
}
