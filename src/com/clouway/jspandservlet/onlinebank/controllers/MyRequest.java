package com.clouway.jspandservlet.onlinebank.controllers;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
* Created by Krasimir Dimitrov
* Email: krasimir.dimitrov@clouway.com.
* Date: 3/19/12
* Time: 11:59 AM
* To change this template use File | Settings | File Templates.
*/
interface MyRequest {
  BigDecimal getValue(String attributeName);

  HttpSession getSession();
}
