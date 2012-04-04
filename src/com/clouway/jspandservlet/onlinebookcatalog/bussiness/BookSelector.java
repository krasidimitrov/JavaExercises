package com.clouway.jspandservlet.onlinebookcatalog.bussiness;

import java.sql.SQLException;
import java.util.List;

/**
 * Handle the selection of books from the data source
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public interface BookSelector {

  public List<Book> getSelectedBooks(int bookPosition, int maxBooks);
}
