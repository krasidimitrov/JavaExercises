package com.clouway.jspandservlet.onlinebookcatalog.bussiness;

import com.clouway.jspandservlet.onlinebookcatalog.persistance.BookRepository;

import java.util.List;

/**
 * Handle the selection of books from the database
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class BookSelectorImpl implements BookSelector {


  private final BookRepository bookRepository;

  public BookSelectorImpl(BookRepository repository) {
    bookRepository = repository;
  }

  /**
   * get Books from the database;
   * @param bookPosition the first book that is going to be get
   * @param maxBooks how many books to get including the first one
   * @return ArrayList with the books
   */
  public List<Book> getSelectedBooks(int bookPosition, int maxBooks){
    return bookRepository.getBooks(bookPosition, maxBooks);
  }
}
