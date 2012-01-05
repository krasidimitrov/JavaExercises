package com.clouway.jdbc.triplog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/4/12
 * Time: 3:41 PM
 */
public class PersonRowMapper implements RowMapper<Person> {

    public Person map(ResultSet resultSet) throws SQLException{
        String name = resultSet.getString("name");
        String egn = resultSet.getString("egn");
        int age = resultSet.getInt("age");
        String email = resultSet.getString("email");

        return new Person(name, egn, age, email);
    }
}
