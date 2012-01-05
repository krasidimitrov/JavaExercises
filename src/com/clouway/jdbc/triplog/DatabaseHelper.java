package com.clouway.jdbc.triplog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
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

    public void executeQuery(String query, Object... params) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        fillParams(preparedStatement,params);

        preparedStatement.execute();
        connection.close();
    }

    private void fillParams(PreparedStatement preparedStatement, Object[] params) throws SQLException{
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
    }

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

