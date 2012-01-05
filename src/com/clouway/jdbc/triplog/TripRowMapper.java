package com.clouway.jdbc.triplog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/5/12
 * Time: 12:53 PM
 */
public class TripRowMapper implements RowMapper<Trip>{


    public Trip map(ResultSet resultSet) throws SQLException {
        String egn = resultSet.getString("egn");
        String departureDate = resultSet.getString("departureDate");
        String returnDate = resultSet.getString("returnDate");
        String cityVisited = resultSet.getString("city");

        return new Trip(egn, departureDate, returnDate, cityVisited);
    }
}
