package com.clouway.jspandservlet.onlinebookcatalog.inject;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.BookSelector;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.BookSelectorImpl;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentHandler;
import com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentHandlerImpl;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.BookDatabaseRepository;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.BookRepository;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.CommentDatabaseRepository;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.CommentRepository;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.ConnectionProvider;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DataSourceCreator;
import com.clouway.jspandservlet.onlinebookcatalog.persistance.DatabaseHelper;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public final class Injector {

  public static DatabaseHelper injectHelper() {
    return new DatabaseHelper(new ConnectionProvider());
  }

  public static BookRepository injectBookRepository() {
    return new BookDatabaseRepository(injectHelper());
  }

  public static CommentRepository injectCommentRepository(){
    return new CommentDatabaseRepository(injectHelper());
  }

  public static CommentHandler injectCommentHandler(){
    return new CommentHandlerImpl(injectCommentRepository());
  }

  public static BookSelector injectBookSelector(){
    return new BookSelectorImpl(injectBookRepository());
  }
}
