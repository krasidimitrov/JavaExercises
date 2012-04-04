package com.clouway.jspandservlet.onlinebookcatalog.controllers;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Comment;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentHandler;
import com.clouway.jspandservlet.onlinebookcatalog.inject.Injector;

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
 * Redirect to book.jsp and get all comments for the book which is going to be visualized in book.jsp
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/8/12
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookServlet extends HttpServlet {
  private CommentHandler commentHandler;
  private List<Book> bookArray;
  private List<Comment> commentArrayList;
  private Book currentBook;

  public void init(ServletConfig config) throws ServletException {
    commentHandler = Injector.injectCommentHandler();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

   HttpSession session = req.getSession();
   bookArray = (ArrayList<Book>) session.getAttribute("bookArray");
   currentBook = bookArray.get(Integer.parseInt(req.getParameter("bookId")));
   commentArrayList = commentHandler.getAllComments(currentBook.getBookId());


    session.setAttribute("currentBook", currentBook);
    session.setAttribute("commentArrayList", commentArrayList);
    resp.sendRedirect(req.getContextPath() + "/onlinebookcatalog/book.jsp");
  }
}
