package com.clouway.jdbc.triplog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 2:24 PM
 */
public class Connect {
    public Connection connectToDatabase(String databaseName, String username,String password){
        Connection connection= null;
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("localhost");
        dataSource.setDatabaseName(databaseName);
        try {
            connection = dataSource.getConnection(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection connectToDatabase(String username,String password){
        Connection connection= null;
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("localhost");
        dataSource.setDatabaseName("sampdb");
        try {
            connection = dataSource.getConnection(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
