package com.clouway.jdbc.triplog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create Person objects from a resultSet
 * Created by Krasimir Dimitrov
 * Date: 1/4/12
 * Time: 3:41 PM
 */
public class PersonRowMapper implements RowMapper<Person> {

    /**
     * Create a Person objects from a given reusltSet
     * @param resultSet the resultSet from which we are going to create an Object
     * @return the Person object created from the given resultSet
     * @throws SQLException
     */
    public Person map(ResultSet resultSet) throws SQLException{
        String name = resultSet.getString("name");
        String egn = resultSet.getString("egn");
        int age = resultSet.getInt("age");
        String email = resultSet.getString("email");

        return new Person(name, egn, age, email);
    }
}
