package model;

import entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
    void createProduct(Product product) throws SQLException;

    Product getProductById(int productId) throws SQLException;

    ArrayList<Product> getAllProducts() throws SQLException;

    void updateProduct(Product product) throws SQLException;

    boolean deleteProduct(int productId) throws SQLException;
}
