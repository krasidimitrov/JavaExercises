package com.clouway.jspandservlet.aop;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class OperationAdditionTest {
  private Operation opAddition = new OperationAddition();
  
  @Test
  public void calculateShouldReturnSumOfTwoIntegerNumbers(){
    int result = opAddition.calculate(3,5);
    assertEquals("Expected result doesn't match the actual",8,result);
  }
}
