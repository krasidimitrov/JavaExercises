package com.clouway.jdbc.triplog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/5/12
 * Time: 12:53 PM
 */
public class CityRowMapper implements RowMapper<City>{


    public City map(ResultSet resultSet) throws SQLException {
        String cityVisited = resultSet.getString("city");
        int timesVisited = resultSet.getInt("timesVisited");

        return new City(cityVisited,timesVisited);
    }
}
