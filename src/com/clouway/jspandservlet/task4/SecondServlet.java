package com.clouway.jspandservlet.task4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/16/12
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class SecondServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("servletName", getServletName());
    req.getRequestDispatcher("/redirectServlet2").forward(req, resp);
  }
}
