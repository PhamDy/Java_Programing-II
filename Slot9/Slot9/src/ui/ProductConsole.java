package ui;

import entity.Product;
import model.ProductDao;
import model.ProductDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductConsole {
    private final Scanner sc;

    ProductDaoImpl productDao = new ProductDaoImpl();

    public ProductConsole() throws SQLException {
        this.sc = new Scanner(System.in);
    }

    private int menu() {
        System.out.println("---PRODUCT MENU---");
        System.out.println("1. Add product");
        System.out.println("2. Show all product");
        System.out.println("3. Remove product");
        System.out.println("0. Exit");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public void start() throws SQLException{
        while (true) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    removeProduct();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private void addProduct() throws SQLException{
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter product desc: ");
        String desc = sc.nextLine();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        Product product = new Product(name, desc, price);
        productDao.createProduct(product);
    }

    private void showAll() throws SQLException {
        System.out.println("--All product--");
        ArrayList<Product> allProducts = productDao.getAllProducts();
        System.out.println(allProducts);
    }

    private void removeProduct() throws SQLException {
        System.out.println("Enter ID of product");
        int id = sc.nextInt();
        sc.nextLine();
        boolean result = productDao.deleteProduct(id);
        if (result) {
            System.out.println("Product was removed");
        } else {
            System.out.println("Product not found");
        }
    }



}
