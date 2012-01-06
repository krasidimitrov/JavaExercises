package com.clouway.jdbc.usershistory;

import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/5/12
 * Time: 2:55 PM
 */
public interface IUserRepository {

    public void enableHistoryOnUpdate() throws SQLException;
    public void disableHistoryOnUpdate() throws SQLException;

    /**
     * Update the email for a chosen user by his username
     * @param username the username of the user for which we are going to update the email
     * @param email the new email for the given user
     * @throws SQLException
     */
    public void updateUserEmail(String username, String email) throws SQLException;

}
