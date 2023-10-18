package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        String url = "jdbc:mySQL://localhost:3306/user";
        String username = "root";
        String password = "";

        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
