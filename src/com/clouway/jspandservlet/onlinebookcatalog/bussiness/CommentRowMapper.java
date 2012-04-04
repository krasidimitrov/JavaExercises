package com.clouway.jspandservlet.onlinebookcatalog.bussiness;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  Construct a comment object from a result set
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/28/12
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommentRowMapper implements RowMapper<Comment> {

  public Comment map(ResultSet resultSet) throws SQLException {
    
    int bookId = resultSet.getInt("bookId");
    String userName = resultSet.getString("userName");
    String comment = resultSet.getString("comment");
    
    return new Comment(bookId, userName, comment);
  }
}
