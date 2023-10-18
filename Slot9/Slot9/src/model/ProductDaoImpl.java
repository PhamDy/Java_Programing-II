package model;

import dao.DBConnection;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao{

    private final Connection conn = DBConnection.getConnection();
    PreparedStatement pstm = null;
    ResultSet resultSet = null;
    private final String SQL_CREATE_PRODUCT = "INSERT INTO products (ProName, ProDesc, Price) VALUES (?, ?, ?)";
    private final String SQL_GET_PRODUCT_BY_ID = "SELECT * FROM products WHERE id=?";
    private final String SQL_GET_ALL_PRODUCTS = "SELECT * FROM products";
    private final String SQL_UPDATE_PRODUCT = "UPDATE products SET ProName=?, ProDesc=?, Price=? WHERE id=?";
    private final String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE id=?";

    public ProductDaoImpl() throws SQLException {

    }

    @Override
    public void createProduct(Product product) throws SQLException {
        pstm = conn.prepareStatement(SQL_CREATE_PRODUCT);
        pstm.setString(1, product.getProductName());
        pstm.setString(2,product.getProductDesc());
        pstm.setDouble(3, product.getProductPrice());
        pstm.executeUpdate();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        Product product = new Product();
        pstm = conn.prepareStatement(SQL_GET_PRODUCT_BY_ID);
        pstm.setInt(1, productId);
        resultSet = pstm.executeQuery();
        while (resultSet.next()){
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setProductDesc(resultSet.getString(3));
            product.setProductPrice(resultSet.getDouble(4));
        }
        return product;
    }

    @Override
    public ArrayList<Product> getAllProducts() throws SQLException {
        Product product = new Product();
        ArrayList<Product> allProducts = new ArrayList<>();
        pstm = conn.prepareStatement(SQL_GET_ALL_PRODUCTS);
        resultSet = pstm.executeQuery();
        while (resultSet.next()){
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setProductDesc(resultSet.getString(3));
            product.setProductPrice(resultSet.getDouble(4));
            allProducts.add(product);
        }
        return allProducts;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        pstm = conn.prepareStatement(SQL_UPDATE_PRODUCT);
        pstm.setString(1, product.getProductName());
        pstm.setString(2,product.getProductDesc());
        pstm.setDouble(3, product.getProductPrice());
        pstm.setInt(4, product.getProductId());
        pstm.executeUpdate();

    }

    @Override
    public boolean deleteProduct(int productId) throws SQLException {
        pstm = conn.prepareStatement(SQL_DELETE_PRODUCT);
        pstm.setInt(1, productId);
        pstm.executeUpdate();
        return true;
    }
}
