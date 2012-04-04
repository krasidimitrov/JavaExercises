package com.clouway.jspandservlet.onlinecalculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 *         To change this template use File | Settings | File Templates.
 */
public class EvaluatorTest {
  private Evaluator evaluator = new Evaluator();

  @Test
  public void subtractionOfTwoPositiveNumbers(){
    assertEquals(4, evaluator.eval("6-2"));
  }

  @Test
  public void subtractionOfNegativeWithPositiveNumbers(){
    assertEquals(-3, evaluator.eval("-2-1"));

  }

  @Test
  public void sumOfTwoPositiveNumbers(){
    assertEquals(8,evaluator.eval("3+5"));
  }

  @Test
  public void sumOfNegativeWithPositiveNumbers(){
    assertEquals(-2,evaluator.eval("-3+1"));
  }

  @Test
  public void multiplicationOfTwoPositiveNumbers(){
    assertEquals(12,evaluator.eval("3*4"));
  }

  @Test
  public void multiplicationOfNegativeWithPositiveNumbers(){
    assertEquals(-10,evaluator.eval("-2*5"));
  }

  @Test
  public void divisionOfTwoPositiveNumbers(){
    assertEquals(3, evaluator.eval("12/4"));
  }

  @Test
  public void divisionOfNegativeNumberWithPositive(){
    assertEquals(-3,evaluator.eval("-12/4"));
  }

  @Test (expected =  ArithmeticException.class)
  public void divisionOnZeroShouldThrowException(){
    evaluator.eval("3/0");
  }

  @Test (expected = InvalidExpressionException.class)
  public void divisionWithoutSecondNumberWillThrowExceptiuon(){
   evaluator.eval("3/");
  }


}
