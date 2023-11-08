package Assignment02.view;

import java.sql.SQLException;
import java.util.Scanner;

import Assignment02.controller.productManager;

public class cosole {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean flag = true;

        do {
            System.out.println("\n\t *** Welcome to Aptech Product *** \t");
            System.out.println("1. Add new product");
            System.out.println("2. Find by product id");
            System.out.println("3. Find by product name");
            System.out.println("4. Delete product by id");
            System.out.println("5. Display all product");
            System.out.println("6. Display all product out of stock");
            System.out.println("7. Display all product bestseller");
            System.out.println("8. Exit");
            System.out.println("--------------------------------------------");
            System.out.println("Please enter your selection: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    productManager.addProductNew();
                    break;
                case 2:
                    productManager.selectById();
                    break;
                case 3:
                    productManager.selectByName();
                    break;
                case 4:
                    productManager.deleteProduvtById();
                    break;
                case 5:
                    productManager.displayAllProduct();
                    break;
                case 6:
                    productManager.displayQuantity();
                    break;
                case 7:
                    productManager.displaySold();
                    break;
                case 8:
                    System.out.println("Exit...");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    System.out.println("Please choose again");
                    break;
            }
        } while (flag);



    }

}
