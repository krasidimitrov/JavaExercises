package com.clouway.jspandservlet.onlinebookcatalog.controllers;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.BookSelector;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.PageNavigator;
import com.clouway.jspandservlet.onlinebookcatalog.inject.Injector;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handle the page changing
 * Control the changing of the pages
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/23/12
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageServlet extends HttpServlet {
  private PageNavigator pageNavigator = new PageNavigator();
  private BookSelector bookSelector;

  public void init(ServletConfig config) throws ServletException {
    bookSelector = Injector.injectBookSelector();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();
    List<Book> bookArray = new ArrayList<Book>();
    if (session.getAttribute("bookPosition") == null) {
      session.setAttribute("bookPosition", 0);
    }
    if (pageNavigator.hasNavigationForKey(req.getParameter("changeValue"))) {
      pageNavigator.navigateTo(req.getParameter("changeValue"), session);
    }

    bookArray = bookSelector.getSelectedBooks(Integer.parseInt(session.getAttribute("bookPosition").toString()), 3);


    session.setAttribute("pageNumber", bookArray.get(bookArray.size()-1).getBookId()/3);
    session.setAttribute("bookArray", bookArray);
    resp.sendRedirect(req.getContextPath() + "/onlinebookcatalog/catalog.jsp");
  }

}
