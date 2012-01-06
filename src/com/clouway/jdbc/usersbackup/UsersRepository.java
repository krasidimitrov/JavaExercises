package com.clouway.jdbc.usersbackup;

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

    public void enableHistoryOnUpdate() throws SQLException{
        databaseHelper.executeQuery("CREATE TRIGGER save_history BEFORE UPDATE ON Users FOR EACH ROW INSERT INTO Users_history VALUES(OLD.name, OLD.email) ON DUPLICATE KEY UPDATE email=OLD.email");

    }

    public void disableHistoryOnUpdate() throws SQLException{
       databaseHelper.executeQuery("DROP TRIGGER save_history");
    }

    public void updateUserEmail(String username,String email) throws SQLException{
        databaseHelper.executeQuery("UPDATE TABLE Users SET email=? WHERE name=?",email,username);
    }
}
