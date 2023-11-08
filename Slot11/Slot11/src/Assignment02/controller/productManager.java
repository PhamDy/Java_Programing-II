package Assignment02.controller;

import Assignment02.entity.Product;
import Assignment02.model.ProductDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class productManager {
    public static void addProductNew() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product id: "); String id = sc.nextLine();
        System.out.println("Enter name product: "); String product_name = sc.nextLine();
        System.out.println("Enter price: "); double price = sc.nextDouble();
        System.out.println("Enter quantity: "); int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter sold: "); int sold = sc.nextInt();
        Product product = new Product(id, product_name, price, quantity, sold);
        ProductDAO.getInstance().insert(product);
        System.out.println("Add product successful");
    }

    public static void selectById() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product id: "); String id = sc.nextLine();
        Product product = ProductDAO.getInstance().selectById(id);
        if (product!=null) {
            System.out.println(product.toString());
        } else {
            System.out.println("Product not find");
        }
    }

    public static void selectByName() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name: "); String name = sc.nextLine();
        Product product = ProductDAO.getInstance().selectByName(name);
        if (product!=null) {
            System.out.println(product.toString());
        } else {
            System.out.println("Product not find");
        }
    }

    public static void deleteProduvtById() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product id: "); String id = sc.nextLine();
        ProductDAO.getInstance().delete(id);
    }

    public static void displayAllProduct() throws SQLException {
        ArrayList<Product> list = ProductDAO.getInstance().selectAll();
        for (Product product: list
             ) {
            System.out.println(product.toString());
        }
    }

    public static void displayQuantity() throws SQLException {
        ArrayList<Product> list = ProductDAO.getInstance().selectByQuantity();
        for (Product product: list
        ) {
            System.out.println(product.toString());
        }
    }

    public static void displaySold() throws SQLException {
        ArrayList<Product> list = ProductDAO.getInstance().selectBySold();
        for (Product product: list
        ) {
            System.out.println(product.toString());
        }
    }


}
