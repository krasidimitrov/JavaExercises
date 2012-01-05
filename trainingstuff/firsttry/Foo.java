package firsttry;

import java.sql.*;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 11:36 AM
 */
public class Foo {
    private Connection connect = null;
    private PreparedStatement preparedStatement= null;

    public void connectToDataBase(String user, String password) {
        try {
            String url = "jdbc:mysql://localhost/sampdb";
            // Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Dtabase connection establieshed");
        } catch (Exception e) {
            System.err.println("Could not connect to database.");
        }
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public void createTable(String tableName) {
        try {
            preparedStatement = connect.prepareStatement("CREATE TABLE " +tableName+"  (id INT, name VARCHAR(20)) ENGINE = InnoDB;");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
