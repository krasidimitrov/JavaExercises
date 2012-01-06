package com.clouway.jdbc.triplog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create City objects from a result set
 * Created by Krasimir Dimitrov
 * Date: 1/5/12
 * Time: 12:53 PM
 */
public class CityRowMapper implements RowMapper<City>{

    /**
     * Create a City objects from a given resultSet
     * @param resultSet the resultSet from which we are going to create an Object
     * @return the City object created from the given resultSet
     * @throws SQLException
     */
    public City map(ResultSet resultSet) throws SQLException {
        String cityVisited = resultSet.getString("city");
        int timesVisited = resultSet.getInt("timesVisited");

        return new City(cityVisited,timesVisited);
    }
}
