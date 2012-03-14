package com.clouway.jspandservlet.onlinebookcatalog.controllers;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Comment;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentRowMapper;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DataSourceCreator;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DatabaseHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/8/12
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookServlet extends HttpServlet {
  DatabaseHelper databaseHelper = new DatabaseHelper(DataSourceCreator.getBookCatalogueDataSource());
  List<Book> bookArray;
  List<Comment> commentArrayList;
  Book currentBook;

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    bookArray = (ArrayList<Book>) session.getAttribute("bookArray");
    currentBook = bookArray.get(Integer.parseInt(req.getParameter("bookId")));
    try {
      commentArrayList = databaseHelper.executeQuery("SELECT * FROM Comments WHERE bookId = ?",new CommentRowMapper(),currentBook.getBookId());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    session.setAttribute("currentBook", currentBook);
    session.setAttribute("commentArrayList",commentArrayList);
//    RequestDispatcher dispatcher = req.getRequestDispatcher("/onlinebookcatalog/book.jsp");
//    dispatcher.forward(req, resp);
   resp.sendRedirect("/war/onlinebookcatalog/book.jsp");
  }
}
