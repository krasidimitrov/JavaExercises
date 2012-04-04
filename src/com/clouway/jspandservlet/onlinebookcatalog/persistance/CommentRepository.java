package com.clouway.jspandservlet.onlinebookcatalog.persistance;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Comment;

import java.util.List;

/**
 * Handle operations with the comments' data source
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public interface CommentRepository {

  /**
   * Save a comment to the data source
   * @param bookId the id of the book for which is the comment
   * @param userName the username of the user that writes the comment
   * @param comment the actual comment
   */
  public void addComment(int bookId, String userName, String comment);

  /**
   * Get all comments for a book from the data source
   * @param bookId the id of the book for which we are going to take all comments
   * @return List of all the comments for a book
   */
  public List<Comment> getComments(int bookId);
}
