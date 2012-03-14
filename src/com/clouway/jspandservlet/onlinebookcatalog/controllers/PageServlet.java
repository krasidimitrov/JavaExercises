package com.clouway.jspandservlet.onlinebookcatalog.controllers;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Resources;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DataSourceCreator;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DatabaseHelper;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.BookRowMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/23/12
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageServlet extends HttpServlet{
  DatabaseHelper helper = new DatabaseHelper(DataSourceCreator.getBookCatalogueDataSource());
  Resources resources = new Resources();

//  protected void setDatabaseHelper(DatabaseHelper helper) {
//    this.helper = helper;
//  }
//
//  public DatabaseHelper getDatabaseHelper() {
//    if (helper == null) {
//      helper = new DatabaseHelper(DataSourceCreator.getBookCatalogueDataSource());
//    }
//    return helper;
//  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   // Map<String, String[]> requestMap = req.getParameterMap();

    HttpSession session = req.getSession();
    List<Book> bookArray = new ArrayList<Book>();
    if(session.getAttribute("bookPosition") == null){
      session.setAttribute("bookPosition", 0);
   }
    
    
    if(resources.hasNavigationForKey(req.getParameter("changeValue"))){      
      resources.navigateTo(req.getParameter("changeValue"), session);      
    }
    try {
      bookArray = helper.executeQuery("SELECT * FROM Books LIMIT ?, ?;",new BookRowMapper(), session.getAttribute("bookPosition"), 3);
    } catch (SQLException e) {
      e.printStackTrace();
    }



    session.setAttribute("bookArray" , bookArray);
    resp.sendRedirect("/war/onlinebookcatalog/catalog.jsp");
  }

}
