package yc.geek.database;

import yc.geek.Utils.Print;
import java.sql.*;

public class DBConnection {

    private static DBConnection instance = null;
    private Connection connection = null;

    private DBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/library_management";
        String username = "postgres";
        String password = "admin";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            Print.log(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null || !instance.connection.isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }

    public static boolean closeConnection() {
        if (instance !=null){
            try {
                instance.getConnection().close();
                instance = null;
                return true;
            } catch (SQLException e) {
                Print.log(e.toString());
            }
        }
        return false;
    }
}
