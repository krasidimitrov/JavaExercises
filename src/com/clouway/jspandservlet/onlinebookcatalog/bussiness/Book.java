package com.clouway.jspandservlet.onlinebookcatalog.bussiness;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/23/12
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
  private int bookId;
  private String title;
  private String publisher;
  private int yearOfPublishing;
  private String description;

  public Book(int bookId, String title, String publisher, int yearOfPublishing, String description) {
    this.bookId = bookId;
    this.title=title;
    this.publisher=publisher;
    this.yearOfPublishing=yearOfPublishing;
    this.description=description;
  }

  public int getBookId() {
    return bookId;
  }

  public String getTitle() {
    return title;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getYearOfPublishing() {
    return yearOfPublishing;
  }

  public String getDescription() {
    return description;
  }
}
