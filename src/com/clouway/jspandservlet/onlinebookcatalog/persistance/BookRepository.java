package com.clouway.jspandservlet.onlinebookcatalog.persistance;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;

import java.util.List;

/**
 *  Handle the operations with the books' data source
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public interface BookRepository {

  /**
   * Get books from the data source
   * @param bookPosition show from which book will begin the getting
   * @param maxBooks the number of books that will be get
   * @return List with books
   */
  public List<Book> getBooks(int bookPosition, int maxBooks);
}
