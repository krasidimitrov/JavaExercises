package com.clouway.jspandservlet.onlinebookcatalog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/28/12
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommentRowMapper implements RowMapper<Comment>{

  public Comment map(ResultSet resultSet) throws SQLException {
    
    int bookId = resultSet.getInt("bookId");
    String userName = resultSet.getString("userName");
    String comment = resultSet.getString("comment");
    
    return new Comment(bookId, userName, comment);
  }
}
