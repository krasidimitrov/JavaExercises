package com.clouway.jspandservlet.onlinebookcatalog.persistance;

import com.clouway.jspandservlet.onlinebookcatalog.bussiness.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Establish connection to the database and execute queries given by a repository classes
 * Created by Krasimir Dimitrov
 * Date: 1/4/12
 * Time: 3:20 PM
 */
public class DatabaseHelper {

  private final Provider<Connection> connectionProvider;

  public DatabaseHelper(Provider<Connection> connectionProvider) {
    this.connectionProvider = connectionProvider;
  }


  /**
   * Execute a query with 0 to n parameters
   *
   * @param query  the query that is executed in a prepare statement
   * @param params the parameters used in the query which is executed
   */
  public void executeQuery(String query, Object... params) {
    Connection connection = null;
    try {
      connection = connectionProvider.get();
      assert false;
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParams(preparedStatement, params);
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Load the parameters fro a query  which is in a prepare statement
   *
   * @param preparedStatement the preparedStatement with the query for which we are going to fill the parameters
   * @param params            the parameters that we use to fill the query in the preparedStatement
   * @throws SQLException
   */
  private void fillParams(PreparedStatement preparedStatement, Object[] params) throws SQLException {
    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i + 1, params[i]);
    }
  }

  /**
   * Execute a query with 0 to N parameters and return the result set in a List of a given type
   *
   * @param query     the query that is executed
   * @param rowMapper used to map the resultSet into objects of the type of the List that we are returning
   * @param params    the parameters for the query that we are going to execute
   * @param <T>       determine for what type of objects is this method going to be (i.e. Person, City, etc)
   * @return a List with objects from the type specific
   */
  public <T> List<T> executeQuery(String query, RowMapper<T> rowMapper, Object... params) {

    Connection connection = null;
    List<T> results = null;

    try {
      connection = connectionProvider.get();
      PreparedStatement preparedStatement = connection.prepareStatement(query);

      fillParams(preparedStatement, params);

      ResultSet resultSet = preparedStatement.executeQuery();

      results = new ArrayList<T>();

      while (resultSet.next()) {
        results.add(rowMapper.map(resultSet));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return results;
  }

  /**
   * \
   * Method used for executing queries that return a single int result
   *
   * @param query  the query that is going to be executed
   * @param params the parameters used in the query if any
   * @return the result from the query
   */
  public int executeQueryWithSingleResult(String query, Object... params) {

    Connection connection = null;
    int count = 0;
    try {
      connection = connectionProvider.get();
      PreparedStatement preparedStatement = connection.prepareStatement(query);

      fillParams(preparedStatement, params);

      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        count = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return count;
  }

}
