package com.clouway.jspandservlet.onlinebookcatalog.bussiness;

import com.clouway.jspandservlet.onlinebookcatalog.exceptions.EmptyFieldException;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.CommentRepository;

import java.util.List;

/**
 * Handle any action with the comments that require a data base
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class CommentHandlerImpl implements CommentHandler {

  private final CommentRepository databaseCommentRepository;

  public CommentHandlerImpl(CommentRepository commentRepository){
    databaseCommentRepository = commentRepository;
  }

  /**
   * Save a comment in the database
   * @param bookId the id of the book for which is the comment
   * @param userName the name of the user that wrote the comment
   * @param comment the actual comment
   */
  public void addComment(int bookId, String userName, String comment){
    if(!userName.equals("") && !comment.equals("")){
    databaseCommentRepository.addComment(bookId, userName, comment);
    } else {
      throw new EmptyFieldException();
    }
  }

  /**
   * Get all comments for a book from the data base
   * @param bookId the id of the book for which we are going to get all the comments
   * @return an ArrayList with all the comment for the current book
   */
  public List<Comment> getAllComments(int bookId){
    return databaseCommentRepository.getComments(bookId);
  }

}
