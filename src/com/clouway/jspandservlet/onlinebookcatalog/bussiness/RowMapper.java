package com.clouway.jspandservlet.onlinebookcatalog.bussiness;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create objects from a result set
 * Created by Krasimir Dimitrov
 * Date: 1/4/12
 * Time: 3:34 PM
 */
public interface RowMapper<T> {

  /**
   * Create objects from type T from a given resultSet
   * @param resultSet the resultSet from which we are going to create an Object
   * @return return object of type T
   * @throws SQLException if a database access error occurs
   */
  T map(ResultSet resultSet) throws SQLException;
}