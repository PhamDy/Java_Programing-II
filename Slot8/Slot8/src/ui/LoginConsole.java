package ui;

import controller.LoginController;
import entity.Users;
import java.io.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginConsole {
    LoginController loginController = new LoginController();
    Users user = new Users();
    private final Scanner sc;

    public LoginConsole() throws IOException {
        this.sc = new Scanner(System.in);
    }

    private int menu() {
        System.out.println("---PRODUCT MENU---");
        System.out.println("1. Login Statement");
        System.out.println("2. Login PreparedStatement");
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
//                case 1:
//                    System.exit(0);
//                    break;
                case 2:
                    loginPreparedStatement();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private int readInt(int max, int min){
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max){
                    break;
                }
            } catch (NumberFormatException e) {

            }
        }
        return choice;
    }

    private void loginPreparedStatement() throws SQLException {
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        String result = loginController.loginPreparedStatementController(user);
        System.out.println(result);
    }

}
