package ManagerEmployee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
    public static void getEmployeeById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter by Id: ");
        String id = scanner.nextLine();

        Employee employee = new Employee(id);

        Employee employee1 = EmployeeImpl.getInstance().selectById(employee);

        if (employee1!=null) {
            System.out.println(employee1.toString());
        } else {
            System.out.println("Employee is not found");
        }
    }

    public static void addEmployee() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id");
        String id = scanner.nextLine();
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter salary");
        String salary = scanner.nextLine();

        Employee employee = new Employee(id, name, salary);
        EmployeeImpl.getInstance().insert(employee);
        System.out.println("Successfully updated customers !!!");
    }

    public static void updateCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        Employee c = new Employee(id, name);

        EmployeeImpl.getInstance().update(c);
        if (c!=null) {
            System.out.println("Successfully updated customers !!!");
        }
    }

    public static void deleteEmployee() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Just enter the customer id to delete: ");
        String id = scanner.nextLine();

        Employee c = new Employee(id);

        EmployeeImpl.getInstance().delete(c);
        System.out.println("Successfully deleted the customer !!!");
    }

    public static void getAllEmployee() throws SQLException {
        ArrayList<Employee> list = EmployeeImpl.getInstance().selectAll();
        for (Employee i: list
             ) {
            System.out.println(i);
        }
    }

}
