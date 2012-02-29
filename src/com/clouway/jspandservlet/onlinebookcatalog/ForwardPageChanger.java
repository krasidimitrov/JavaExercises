package com.clouway.jspandservlet.onlinebookcatalog;

import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/28/12
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class ForwardPageChanger implements PageChanger {
  private DatabaseHelper helper = new DatabaseHelper(DataSourceCreator.getBookCatalogueDataSource());
  private int bookCount;

  public int change(int position) {
    try {
      bookCount = helper.executeQueryWithSingleResult("SELECT COUNT(*) FROM Books");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int newPosition = position + 3;
    if (newPosition >= bookCount) {
      return 0;
    }
    return newPosition;
  }
}
