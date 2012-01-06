package com.clouway.jdbc.usershistory;

import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/5/12
 * Time: 2:55 PM
 */
public class UsersRepository implements IUserRepository{

    private DatabaseHelper databaseHelper;

    public UsersRepository(DatabaseHelper databaseHelper){
        this.databaseHelper = databaseHelper;
    }

    /**
     * Create a trigger which saves everything on update in the Users_history table
     * @throws SQLException
     */
    public void enableHistoryOnUpdate() throws SQLException{
        databaseHelper.executeQuery("CREATE TRIGGER save_history BEFORE UPDATE ON Users FOR EACH ROW INSERT INTO Users_history(id, name, salary, email, city) VALUES(OLD.id, OLD.name, OLD.salary, OLD.email, OLD.city) ON DUPLICATE KEY UPDATE email=OLD.email");

    }

    /**
     * Drop the trigger that saves everything on update in the Users_history table
     * @throws SQLException
     */
    public void disableHistoryOnUpdate() throws SQLException{
       databaseHelper.executeQuery("DROP TRIGGER save_history");
    }

    /**
     * Update the email of a user chosen by his username
     * @param username the usernam of the user for which we are going to update the email
     * @param email the new email for the selected user
     * @throws SQLException
     */
    public void updateUserEmail(String username,String email) throws SQLException{
        databaseHelper.executeQuery("UPDATE TABLE Users SET email=? WHERE name=?",email,username);
    }
}
