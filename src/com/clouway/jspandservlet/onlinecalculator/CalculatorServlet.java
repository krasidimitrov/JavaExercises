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
 */
public class CalculatorServlet extends HttpServlet{
  private Evaluator evaluation = new Evaluator();

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int number;
    try{
    number = evaluation.eval(req.getParameter("calcField"));
        req.setAttribute("result", number);
    } catch (ArithmeticException e){
      req.setAttribute("result", "infinity");
    } catch (InvalidExpressionException e){
      req.setAttribute("result", req.getParameter("calcField"));
    }
    req.getRequestDispatcher("/onlinecalculator/calculator.jsp").forward(req,resp);
  }
}
