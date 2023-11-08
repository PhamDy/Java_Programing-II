package Assignment02.model;

import Assignment02.dao.DBConnection;
import Assignment02.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements DAOIterface<Product>{

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;

    public static ProductDAO getInstance() {
        return new ProductDAO();
    }
    @Override
    public void insert(Product product) throws SQLException {
        connection = DBConnection.getConnection();

        String query ="INSERT INTO product(id, product_name, price, quantity, sold)" +
                " VALUES (?, ?, ?, ?, ?) ";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getId());
        preparedStatement.setString(2, product.getProduct_name());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4, product.getQuantity());
        preparedStatement.setInt(5, product.getSold());

        preparedStatement.executeUpdate();

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);
    }

    @Override
    public Product selectById(String id) throws SQLException {
        Product product = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM product WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            product = new Product();
            product.setId(resultSet.getString(1));
            product.setProduct_name(resultSet.getString(2));
            product.setPrice(resultSet.getDouble(3));
            product.setQuantity(resultSet.getInt(4));
            product.setPrice(resultSet.getInt(5));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return product;
    }

    @Override
    public Product selectByName(String name) throws SQLException {
        Product product = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM product WHERE product_name = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            product = new Product();
            product.setId(resultSet.getString(1));
            product.setProduct_name(resultSet.getString(2));
            product.setPrice(resultSet.getDouble(3));
            product.setQuantity(resultSet.getInt(4));
            product.setPrice(resultSet.getInt(5));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return product;
    }

    @Override
    public void delete(String id) throws SQLException {
        int result = 0;
        connection = DBConnection.getConnection();

        String query ="DELETE FROM product WHERE id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);

        result = preparedStatement.executeUpdate();
        if (result>0) {
            System.out.println("Delete successfully");
        } else {
            System.out.println("Delete failed");
        }
    }

    @Override
    public ArrayList<Product> selectAll() throws SQLException {
        ArrayList<Product> list = new ArrayList<>();

        connection = DBConnection.getConnection();

        String query ="SELECT * FROM product";
        preparedStatement = connection.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Product product = new Product();
            product.setId(resultSet.getString(1));
            product.setProduct_name(resultSet.getString(2));
            product.setPrice(resultSet.getDouble(3));
            product.setQuantity(resultSet.getInt(4));
            product.setPrice(resultSet.getInt(5));
            list.add(product);
        }
        return list;
    }

    public ArrayList<Product> selectByQuantity() throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        connection = DBConnection.getConnection();
        String query ="SELECT * FROM product WHERE quantity = 0 ";

        preparedStatement = connection.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getString(1));
            product.setProduct_name(resultSet.getString(2));
            product.setPrice(resultSet.getDouble(3));
            product.setQuantity(resultSet.getInt(4));
            product.setPrice(resultSet.getInt(5));
            list.add(product);
        }
        return list;
    }

    public ArrayList<Product> selectBySold() throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        connection = DBConnection.getConnection();
        String query ="SELECT * FROM product WHERE sold > 200";

        preparedStatement = connection.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getString(1));
            product.setProduct_name(resultSet.getString(2));
            product.setPrice(resultSet.getDouble(3));
            product.setQuantity(resultSet.getInt(4));
            product.setSold(resultSet.getInt(5));
            list.add(product);
        }
        return list;
    }


}
