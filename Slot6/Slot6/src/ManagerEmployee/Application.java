package ManagerEmployee;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean flag = true;
        do {
            System.out.println("===========Menu===========");
            System.out.println("1. Get Employee by id");
            System.out.println("2. Add Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Get All Employee");
            System.out.println("6. Exit");
            System.out.println("--------------------------------------------");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    EmployeeController.getEmployeeById();
                    break;
                case 2:
                    EmployeeController.addEmployee();
                    break;
                case 3:
                    EmployeeController.updateCustomer();
                    break;
                case 4:
                    EmployeeController.deleteEmployee();
                    break;
                case 5:
                    EmployeeController.getAllEmployee();
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
