package Assignment_01.view;

import Assignment_01.controller.ManagerBook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class BookConsole {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean flag = true;

        do {
            System.out.println("\n\t *** Welcome to Aptech Library *** \t");
            System.out.println("1. Create a new Book");
            System.out.println("2. Find by book id");
            System.out.println("3. Find by book name");
            System.out.println("4. Lend books to students");
            System.out.println("5. Displays a list of books students have borrowed");
            System.out.println("6. Exit");
            System.out.println("--------------------------------------------");
            System.out.println("Please enter your selection: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ManagerBook.addNewBook();
                    break;
                case 2:
                    ManagerBook.findBookById();
                    break;
                case 3:
                    ManagerBook.findBookByName();
                    break;
                case 4:
                    ManagerBook.borrowBooks();
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
        } while (flag);


    }
}
