package com.clouway.jspandservlet.onlinebookcatalog.bussiness;

import java.util.List;

/**
 * Handle any action with the comments that require a data source
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public interface CommentHandler {

  /**
   * Save a comment in the data source
   * @param bookId the id of the book for which is the comment
   * @param userName the name of the user that wrote the comment
   * @param comment the actual comment
   */
  public void addComment(int bookId, String userName, String comment);

  /**
   * Get all comments for a book from the data source
   * @param bookId the id of the book for which we are going to get all the comments
   * @return an ArrayList with all the comments for the book
   */
  public List<Comment> getAllComments(int bookId);
}
