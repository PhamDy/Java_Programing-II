package Controller;

import Model.customer;
import DAO.customerDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class customerController {


    public static void createCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        customer c = new customer(id, name);

        customerDAO.getInstance().insert(c);
        System.out.println("Successfully added new customers !!!");
    }

    public static void updateCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        customer c = new customer(id, name);

        customerDAO.getInstance().update(c);
        System.out.println("Successfully updated customers !!!");
    }

    public static void deleteCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Just enter the customer id to delete: ");
        int id = scanner.nextInt();

        customer c = new customer(id);

        customerDAO.getInstance().delete(c);
        System.out.println("Successfully deleted the customer !!!");
    }

    public static void findByIdCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the customer id you want to find: ");
        int id = scanner.nextInt();

        customer c = new customer(id);

        customer c1 = customerDAO.getInstance().selectById(c);
        if (c1!=null) {
            System.out.println(c1.toString());
        } else {
            System.out.println("Customer id not found");
        }
    }

    public static void displayCustomer() throws SQLException {
        ArrayList<customer> list = customerDAO.getInstance().selectAll();
        for (customer i: list
             ) {
            System.out.println(i);
        }
    }

}
