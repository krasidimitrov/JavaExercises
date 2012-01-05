package com.clouway.jdbc.triplog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/4/12
 * Time: 3:34 PM
 */
public interface RowMapper<T> {

    T map(ResultSet resultSet) throws SQLException;
}
