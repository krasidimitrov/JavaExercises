package com.clouway.jspandservlet.onlinebookcatalog.controllers;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Comment;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentRowMapper;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DataSourceCreator;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DatabaseHelper;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
 * Time: 5:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommentServlet extends HttpServlet {
  DatabaseHelper helper = new DatabaseHelper(DataSourceCreator.getBookCatalogueDataSource());
  List<Comment> commentArrayList;

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    Book currentBook = (Book) session.getAttribute("currentBook");//session.getAttribute("currentBook");

    if (!req.getParameter("userName").equals("") && !req.getParameter("comment").equals("")) {
      try {
        helper.executeQuery("INSERT INTO Comments VALUES(\\N, ?, ?, ?);", currentBook.getBookId(), req.getParameter("userName"), req.getParameter("comment"));
        commentArrayList = helper.executeQuery("SELECT * FROM Comments WHERE bookId = ?",new CommentRowMapper(),currentBook.getBookId());
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    session.setAttribute("commentArrayList", commentArrayList);
//    RequestDispatcher dispatcher = req.getRequestDispatcher("/onlinebookcatalog/book.jsp");
//    dispatcher.forward(req,resp);
    resp.sendRedirect("/war/onlinebookcatalog/book.jsp");
  }
}
