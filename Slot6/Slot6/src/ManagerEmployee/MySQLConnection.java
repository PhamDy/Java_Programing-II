package ManagerEmployee;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLConnection  {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        String url = "jdbc:mySQL://localhost:3306/slot6";
        String username = "root";
        String password = "";

        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    // Ngắt kết nối
    public static void closeConnection(Connection connection) throws SQLException{
        if (connection!=null) {
            connection.close();
        }
    }

    public static void closePreparedstatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement!=null){
            preparedStatement.close();
        }
    }

    public static void closeResultset(ResultSet resultSet) throws SQLException {
        if (resultSet!=null) {
            resultSet.close();
        }
    }




}
