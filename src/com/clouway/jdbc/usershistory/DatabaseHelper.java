package com.clouway.jdbc.usershistory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}

