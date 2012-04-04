package com.clouway.jspandservlet.onlinebookcatalog.persistance;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Comment;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentRowMapper;

import java.util.List;

/**
 * Handle operations with the Comment table from the database
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class CommentDatabaseRepository implements CommentRepository{

  private DatabaseHelper databaseHelper;

  public CommentDatabaseRepository(DatabaseHelper helper){
    databaseHelper = helper;
  }

  /**
   * Add a comment to the database
   * @param bookId the id of the book for which is the comment
   * @param userName the username of the user that writes the comment
   * @param comment the actual comment
   */
  public void addComment(int bookId, String userName, String comment) {
    databaseHelper.executeQuery("INSERT INTO Comments VALUES(\\N, ?, ?, ?);", bookId, userName, comment);
  }

  /**
   * Get all comments for a book from the database
   * @param bookId the id of the book for which we are going to take all comments
   * @return ArrayList from all the comments for a book
   */
  public List<Comment> getComments(int bookId) {
    return databaseHelper.executeQuery("SELECT * FROM Comments WHERE bookId = ?",new CommentRowMapper(),bookId);
  }
}
