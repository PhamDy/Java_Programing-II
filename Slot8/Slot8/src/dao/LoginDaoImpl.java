package dao;

import entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;



    @Override
    public String checkLoginPreparedStatement(Users user) throws SQLException{
        // Bước 1: Tạo kết nối
        connection = DBConnection.getConnection();

        // Bước 2: Tạo đối tượng PreparedStatement
        String query ="SELECT username FROM users WHERE username like ? and password like ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());

        // Bước 3: Thực thi câu lệnh SQL

        System.out.println(query);
        resultSet = preparedStatement.executeQuery();

        // Bước 4: Lấy giá trị ketQua
        while (resultSet.next()){
            System.out.println("Username is: " + resultSet.getString("username"));
            return resultSet.getString("username");
        }

        return "Not in the database";
    }
}
