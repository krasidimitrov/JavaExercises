//package com.clouway.jspandservlet.onlinebank.controllers;
//
//import org.jmock.Expectations;
//import org.jmock.Mockery;
//import org.jmock.integration.junit4.JMock;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import javax.servlet.http.HttpServletRequest;
//import java.math.BigDecimal;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.closeTo;
//import static org.junit.Assert.assertThat;
//
///**
// * Created by Krasimir Dimitrov
// * Email: krasimir.dimitrov@clouway.com.
// * Date: 3/19/12
// * Time: 12:07 PM
// * To change this template use File | Settings | File Templates.
// */
//@RunWith(JMock.class)
//public class MyRequestImplTest {
//
//  Mockery context = new Mockery();
//
//  @Test
//  public void bigDecimalValue() {
//    MyRequestImpl myRequest = pretendRequestContains("test", "20");
//    assertThat(myRequest.getValue("test"), is(equalTo(new BigDecimal(20))));
//  }
//
//  @Test
//  public void negativeBigDecimalValue() {
//    MyRequestImpl myRequest = pretendRequestContains("test", "-10");
//    assertThat(myRequest.getValue("test"), is(equalTo(new BigDecimal(-10))));
//  }
//
//  @Test
//  public void fractionPartIsRetrieved() {
//    MyRequestImpl myRequest = pretendRequestContains("test", "10.23");
//    assertThat(myRequest.getValue("test").doubleValue(), is(closeTo(new BigDecimal(10.23).doubleValue(),0.1d)));
//  }
//
//  @Test(expected = IllegalStateException.class)
//  public void charactersAreNotAllowedForBigDecimalNumbers() {
//    MyRequestImpl myRequest = pretendRequestContains("test", "aa.23");
//    myRequest.getValue("test");
//  }
//
//  private MyRequestImpl pretendRequestContains(final String atttributeName, final String attributeValue) {
//    final HttpServletRequest request= context.mock(HttpServletRequest.class);
//
//    context.checking(new Expectations() {{
//      oneOf(request).getAttribute(atttributeName);
//      will(returnValue(attributeValue));
//    }});
//
//    return new MyRequestImpl(request);
//  }
//}
