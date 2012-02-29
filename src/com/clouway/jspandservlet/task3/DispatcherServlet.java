package com.clouway.jspandservlet.task3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/16/12
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class DispatcherServlet extends HttpServlet{
  private List<String> links = new LinkedList<String>();
  HttpSession checkSession = null;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String page = req.getParameter("page");
    HttpSession session= req.getSession();
    if(checkSession !=session){
      checkSession=session;
      links.clear();
    }
    if(!links.contains(page)){
      links.add(page);
      session.setAttribute("message","Hello newcomer!");
    } else {
      session.setAttribute("message","Hello old timer!");
    }
    resp.sendRedirect(page);
  }
}
