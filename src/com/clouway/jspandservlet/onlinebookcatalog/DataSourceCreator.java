package com.clouway.jspandservlet.onlinebookcatalog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/28/12
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataSourceCreator {


  public static DataSource getBookCatalogueDataSource(){
    MysqlDataSource dataSource = new MysqlDataSource();
    dataSource.setServerName("localhost");
    dataSource.setDatabaseName("BookCatalogDatabase");
    dataSource.setUser("kpackapgo");
    dataSource.setPassword("");
    return dataSource;
  }
}
