package connecttobase;

import java.sql.*;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 11:23 AM
 */
public class Connect {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            String userName = "kpackapgo";
            String url = "jdbc:mysql://localhost/sampdb";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, "");
            System.out.println("Dtabase connection establieshed");
        } catch (Exception e) {
            System.err.println("Cannot connect to db server");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("db connection terminated");
                } catch (Exception e) {
                }
            }
        }
    }
}
