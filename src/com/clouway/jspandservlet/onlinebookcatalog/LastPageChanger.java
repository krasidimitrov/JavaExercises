package com.clouway.jspandservlet.onlinebookcatalog;

import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/28/12
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class LastPageChanger implements PageChanger{
  private DatabaseHelper helper = new DatabaseHelper(DataSourceCreator.getBookCatalogueDataSource());
  private int bookCount;


  public int change(int position) {
    try {
      bookCount = helper.executeQueryWithSingleResult("SELECT COUNT(*) FROM Books");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if(bookCount%3==0)
    {
      return bookCount-3;
    }
    return bookCount-bookCount%3;
  }
}
