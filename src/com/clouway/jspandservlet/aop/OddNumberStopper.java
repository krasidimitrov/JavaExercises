package com.clouway.jspandservlet.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class OddNumberStopper implements MethodInterceptor{

  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    Object[] numbers = methodInvocation.getArguments();
    if(Integer.parseInt(String.valueOf(numbers[0]))%2!=0 || Integer.parseInt(String.valueOf(numbers[1]))%2!=0){
      throw new NumbersAreNotEvenException();
    }
    return methodInvocation.proceed();
  }
}
