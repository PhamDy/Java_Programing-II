package ManagerEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeImpl implements EmployeeDAO<Employee>{

    public static EmployeeImpl getInstance() {
        return new EmployeeImpl();
    }

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public int insert(Employee employee) throws SQLException {
        // Buoc 1: Tao ket noi
        connection = MySQLConnection.getConnection();

        // Buoc 2: Tao doi tuong PreparedStatement
        String query = "INSERT INTO employee(id, name, salary)" +
                " VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getId());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getSalary());

        // Buoc 3: Thuc thi cau lenh SQL:
        int ketQua = preparedStatement.executeUpdate();

        // Buoc 4: Ngat ket noi
        MySQLConnection.closePreparedstatement(preparedStatement);
        MySQLConnection.closeConnection(connection);
        return ketQua;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        // Buoc 1: Tao ket noi
        connection = MySQLConnection.getConnection();

        // Buoc 2: Tao doi tuong PreparedStatement
        String query = "UPDATE employee SET name = ? WHERE id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getId());

        // Buoc 3: Thuc thi cau lenh SQL:
        int ketQua = preparedStatement.executeUpdate();
        if (ketQua>0) {
            System.out.println("An existing user was updated successfully");
        } else {
            System.out.println("Failed to update data ...");
        }

        // Buoc 4: Ngat ket noi
        MySQLConnection.closePreparedstatement(preparedStatement);
        MySQLConnection.closeConnection(connection);
        return ketQua;
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        // Buoc 1: Tao ket noi
        connection = MySQLConnection.getConnection();

        // Buoc 2: Tao doi tuong PreparedStatement
        String query = "DELETE FROM employee WHERE id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getId());

        // Buoc 3: Thuc thi cau lenh SQL:
        int ketQua = preparedStatement.executeUpdate();

        // Buoc 4: Ngat ket noi
        MySQLConnection.closePreparedstatement(preparedStatement);
        MySQLConnection.closeConnection(connection);
        return ketQua;
    }

    @Override
    public ArrayList<Employee> selectAll() throws SQLException {
        ArrayList<Employee> ketQua = new ArrayList<>();
        // Buoc 1: Tao ket noi
        connection = MySQLConnection.getConnection();

        // Buoc 2: Tao doi tuong PreparedStatement
        String query = "SELECT * FROM employee";
        preparedStatement = connection.prepareStatement(query);


        // Buoc 3: Thuc thi cau lenh SQL:
        resultSet = preparedStatement.executeQuery();

        // Buoc 4: add Ket qua
        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String salary = resultSet.getString("salary");
            Employee employee = new Employee(id, name, salary);
            ketQua.add(employee);
        }
        // Buoc 5: Ngat ket noi
        MySQLConnection.closePreparedstatement(preparedStatement);
        MySQLConnection.closeResultset(resultSet);
        MySQLConnection.closeConnection(connection);
        return ketQua;
    }

    @Override
    public Employee selectById(Employee employee) throws SQLException {
        Employee ketQua = null;

        // Bước 1: Tạo kết nối
        connection = MySQLConnection.getConnection();

        // Bước 2: Tạo đối tượng PreparedStatement
        String query ="SELECT * FROM employee WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getId());

        // Bước 3: Thực thi câu lệnh SQL

        System.out.println(query);
        resultSet = preparedStatement.executeQuery();

        // Bước 4: Lấy giá trị ketQua
        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String salary = resultSet.getString("salary");

            ketQua = new Employee(id, name, salary);
        }

        // Bước 5: Ngắt kết nối
        MySQLConnection.closePreparedstatement(preparedStatement);
        MySQLConnection.closeResultset(resultSet);
        MySQLConnection.closeConnection(connection);

        return ketQua;
    }
}
