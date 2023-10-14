package database;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection() throws SQLException {
        Connection c = null;
        // Đăng ký MySQL driver với DriverManager
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        String url = "jdbc:mySQL://localhost:3306/customers";
        String username = "root";
        String password = "";

        // Tạo kết nối
        c = DriverManager.getConnection(url, username, password);

        return c;
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
