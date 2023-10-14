package View;
import java.sql.*;
import java.util.Scanner;
import Controller.customerController;
public class Test {
    public static void main(String[] args) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean flag = true;
        do {
            System.out.println("\n\t *** Welcome to Aptech Bank Online *** \t");
            System.out.println("1. Create a new Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Find by id");
            System.out.println("5. Display Customer information");
            System.out.println("6. Exit");
            System.out.println("--------------------------------------------");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    customerController.createCustomer();
                    break;
                case 2:
                    customerController.updateCustomer();
                    break;
                case 3:
                    customerController.deleteCustomer();
                    break;
                case 4:
                    customerController.findByIdCustomer();
                    break;
                case 5:
                    customerController.displayCustomer();
                    break;
                case 6:
                    System.out.println("Exit...");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    System.out.println("Please choose again");
                    break;
            }
        }while (flag);
    }
}
