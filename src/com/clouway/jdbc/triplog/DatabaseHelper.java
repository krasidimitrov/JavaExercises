package com.clouway.jdbc.triplog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

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

    private MysqlDataSource dataSource;

    public DatabaseHelper(){
        dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("sampdb");
        dataSource.setUser("kpackapgo");
        dataSource.setPassword("");
    }

    /**
     * Execute a query with 0 to n parameters
     * @param query the query that is executed in a prepare statement
     * @param params the parameters used in the query which is executed
     * @throws SQLException
     */
    public void executeQuery(String query, Object... params) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        fillParams(preparedStatement,params);

        preparedStatement.execute();
        connection.close();
    }

    /**
     * Load the parameters fro a query  which is in a prepare statement
     * @param preparedStatement the preparedStatement with the query for which we are going to fill the parameters
     * @param params the parameters that we use to fill the query in the preparedStatement
     * @throws SQLException
     */
    private void fillParams(PreparedStatement preparedStatement, Object[] params) throws SQLException{
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
    }

    /**
     * Execute a query with 0 to N parameters and return the result set in a List of a given type
     * @param query the query that is executed
     * @param rowMapper used to map the resultSet into objects of the type of the List that we are returning
     * @param params the parameters for the query that we are going to execute
     * @param <T> determine for what type of objects is this method going to be (i.e. Person, City, etc)
     * @return a List with objects from the type specific
     * @throws SQLException
     */
    public<T> List<T> executeQuery(String query, RowMapper<T> rowMapper, Object... params) throws SQLException {

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        fillParams(preparedStatement, params);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<T> results = new ArrayList<T>();

        while(resultSet.next()){
            results.add(rowMapper.map(resultSet));
        }

        connection.close();

        return results;
    }
}

