package com.clouway.jspandservlet.onlinebookcatalog.controllers;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Comment;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentRowMapper;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DataSourceCreator;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DatabaseHelper;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/9/12
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageFilter implements Filter {
  DatabaseHelper databaseHelper = new DatabaseHelper(DataSourceCreator.getBookCatalogueDataSource());
  List<Comment> commentArrayList;
  Book currentBook;

  private FilterConfig filterConfig;

  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpSession session = ((HttpServletRequest)  servletRequest).getSession();
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    if(session.isNew()){
      ((HttpServletResponse) servletResponse).sendRedirect("../pageServlet");
    }
    currentBook =  (Book) session.getAttribute("currentBook");
    try {
      commentArrayList = databaseHelper.executeQuery("SELECT * FROM Comments WHERE bookId = ?",new CommentRowMapper(),currentBook.getBookId());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    request.setAttribute("commentArrayList", commentArrayList);
    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {
    filterConfig = null;
  }
}
