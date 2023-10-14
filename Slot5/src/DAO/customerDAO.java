package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.customer;
import database.JDBCUtil;

public class customerDAO implements DAOInterface<customer>{

    public static customerDAO getInstance(){
        return new customerDAO();
    }
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;

    @Override
    public int insert(customer o) throws SQLException{
        // Bước 1: Tạo kết nối
        connection = JDBCUtil.getConnection();

        // Bước 2: Tạo đối tượng PreparedStatement
        String query ="INSERT INTO customer(id, name)" +
                " VALUES (?, ?) ";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, o.getId());
        preparedStatement.setString(2, o.getName());

        // Bước 3: Thực thi câu lệnh SQL
        int ketQua = preparedStatement.executeUpdate();
        System.out.println(query);
        System.out.println("Có " + ketQua + " thay đổi");

        // Bước 4: Ngắt kết nối
        JDBCUtil.closePreparedstatement(preparedStatement);
        JDBCUtil.closeConnection(connection);

        return ketQua;
    }

    @Override
    public int update(customer o) throws SQLException{
        // Bước 1: Tạo kết nối
        connection = JDBCUtil.getConnection();

        // Bước 2: Tạo đối tượng PreparedStatement
        String query ="UPDATE customer " +
                " SET name = ?" +
                " WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, o.getName());
        preparedStatement.setInt(2, o.getId());

        // Bước 3: Thực thi câu lệnh SQL
        int ketQua = preparedStatement.executeUpdate();
        System.out.println(query);
        System.out.println("Có " + ketQua + " thay đổi");

        // Bước 4: Ngắt kết nối
        JDBCUtil.closePreparedstatement(preparedStatement);
        JDBCUtil.closeConnection(connection);

        return ketQua;
    }

    @Override
    public int delete(customer o) throws SQLException{
        // Bước 1: Tạo kết nối
        connection = JDBCUtil.getConnection();

        // Bước 2: Tạo đối tượng PreparedStatement
        String query ="DELETE FROM customer WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, o.getId());

        // Bước 3: Thực thi câu lệnh SQL
        int ketQua = preparedStatement.executeUpdate();
        System.out.println(query);
        System.out.println("Có " + ketQua + " thay đổi");

        // Bước 4: Ngắt kết nối
        JDBCUtil.closePreparedstatement(preparedStatement);
        JDBCUtil.closeConnection(connection);

        return ketQua;
    }

    @Override
    public ArrayList selectAll() throws SQLException{
        ArrayList<customer> ketQua = new ArrayList<customer>();

        // Bước 1: Tạo kết nối
        connection = JDBCUtil.getConnection();

        // Bước 2: Tạo đối tượng PreparedStatement
        String query ="SELECT * FROM customer ";

        preparedStatement = connection.prepareStatement(query);

        // Bước 3: Thực thi câu lệnh SQL

        System.out.println(query);
        resultSet = preparedStatement.executeQuery();

        // Bước 4: Lấy giá trị ketQua
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            customer c = new customer(id, name);
            ketQua.add(c);
        }

        // Bước 5: Ngắt kết nối
        JDBCUtil.closePreparedstatement(preparedStatement);
        JDBCUtil.closeResultset(resultSet);
        JDBCUtil.closeConnection(connection);

        return ketQua;
    }

    @Override
    public customer selectById(customer o) throws SQLException{
        customer ketQua = null;

        // Bước 1: Tạo kết nối
        connection = JDBCUtil.getConnection();

        // Bước 2: Tạo đối tượng PreparedStatement
        String query ="SELECT * FROM customer WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,o.getId());

        // Bước 3: Thực thi câu lệnh SQL

        System.out.println(query);
        resultSet = preparedStatement.executeQuery();

        // Bước 4: Lấy giá trị ketQua
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            ketQua = new customer(id, name);
        }

        // Bước 5: Ngắt kết nối
        JDBCUtil.closePreparedstatement(preparedStatement);
        JDBCUtil.closeResultset(resultSet);
        JDBCUtil.closeConnection(connection);

        return ketQua;
    }




}
