package com.clouway.jspandservlet.onlinebookcatalog.controllers;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Comment;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentHandler;
import com.clouway.jspandservlet.onlinebookcatalog.exceptions.EmptyFieldException;
import com.clouway.jspandservlet.onlinebookcatalog.inject.Injector;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Handle the adding of new comment for the current book visualized in book.jsp
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/9/12
 * Time: 5:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommentServlet extends HttpServlet {
  private CommentHandler commentHandler;
  private List<Comment> commentArrayList;

  @Override
  public void init(ServletConfig config) throws ServletException {
    commentHandler = Injector.injectCommentHandler();
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    Book currentBook = (Book) session.getAttribute("currentBook");

    try {
      commentHandler.addComment(currentBook.getBookId(), req.getParameter("userName"), req.getParameter("comment"));
      commentArrayList = commentHandler.getAllComments(currentBook.getBookId());
    } catch (EmptyFieldException e) {
      //handle the exception if userName or comment is an empty space
    }
    session.setAttribute("commentArrayList", commentArrayList);
    resp.sendRedirect(req.getContextPath() + "/onlinebookcatalog/book.jsp");
  }
}
