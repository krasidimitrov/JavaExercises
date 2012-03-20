package com.clouway.jspandservlet.onlinebank.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/19/12
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyRequestImpl implements MyRequest {
  private final HttpServletRequest req;

  public MyRequestImpl(HttpServletRequest req) {

    this.req = req;
  }

  public BigDecimal getValue(String attributeName) {
    try {
    return new BigDecimal((String) req.getAttribute(attributeName));
    } catch (NumberFormatException e) {
      throw new IllegalStateException("Number was not valid.");
    }
  }

  public HttpSession getSession() {
    return req.getSession();
  }
}
