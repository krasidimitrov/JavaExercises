package com.clouway.jspandservlet.onlinecalculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Used to call the eval function and return result in the calculator
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/21/12
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorServlet extends HttpServlet{
  private Evaluator evaluation = new Evaluator();

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int number = evaluation.eval(req.getParameter("calcField"));
    HttpSession session = req.getSession();
    session.setAttribute("result",number);
    resp.sendRedirect("/war/onlinecalculator/calculator.jsp");
  }
}
