package Dangerous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by cgeleta on 12/12/16.
 */
public class MysqlConnection {

    public static Boolean isRegistered() {

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("::Driver has been registered");
            return true;

        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            return false;
        }

    }

    public static Connection connect(String database, String username, String password) {

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "" +
                    "?user=" + username + "&password=" + password);
            System.out.println("::Connection has been made");

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        return conn;
    }


}
