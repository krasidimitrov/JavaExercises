package com.clouway.jdbc.usersbackup;

import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/5/12
 * Time: 2:55 PM
 */
public interface IUserRepository {

    public void enableHistoryOnUpdate() throws SQLException;
    public void disableHistoryOnUpdate() throws SQLException;

    public void updateUserEmail(String username, String email) throws SQLException;

}
