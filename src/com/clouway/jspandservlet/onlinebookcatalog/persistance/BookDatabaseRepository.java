package com.clouway.jspandservlet.onlinebookcatalog.persistance;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.BookRowMapper;

import java.util.List;

/**
 * Handle operations with the Book table from the database
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class BookDatabaseRepository implements BookRepository{

  private DatabaseHelper databaseHelper;

  public BookDatabaseRepository(DatabaseHelper helper){
    databaseHelper=helper;
  }

  /**\
   * Get books from a database
   * @param bookPosition show from which book will begin the getting
   * @param maxBooks the number of books that will be get
   * @return ArrayList with the books taken
   */
  public List<Book> getBooks(int bookPosition, int maxBooks){
    return databaseHelper.executeQuery("SELECT * FROM Books LIMIT ?, ?;",new BookRowMapper(), bookPosition, maxBooks);
  }
}
