package Assignment_01.controller;

import Assignment_01.entity.Book;
import Assignment_01.model.BookDAO;
import Assignment_01.model.StudentDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerBook {

    public static void addNewBook() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id: "); String id = sc.nextLine();
        System.out.println("Enter name: "); String name = sc.nextLine();
        System.out.println("Enter author: "); String author = sc.nextLine();
        System.out.println("Enter publisher: "); String publisher = sc.nextLine();
        System.out.println("Enter category: "); String category = sc.nextLine();
        System.out.println("Enter price: "); double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter date add: "); String dateAdd = sc.nextLine(); ;
        System.out.println("Enter status"); boolean status = sc.nextBoolean();

        Book book = new Book(id, name, author, publisher, category, price, Date.valueOf(dateAdd), status);

        BookDAO.getInstance().insert(book);
        System.out.println("Successfully added new book !!!");
    }

    public static void findBookById() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book id you want to find: ");
        String id = sc.nextLine();

        Book book1 = BookDAO.getInstance().selectById(id);
        if (book1!=null) {
            System.out.println(book1.toString());
        } else {
            System.out.println("Book id not found");
        }
    }

    public static void findBookByName() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book name you want to find: ");
        String name = sc.nextLine();
        Book book = new Book();
        book.setName(name);

        Book book1 = BookDAO.getInstance().selectByName(name);
        if (book1!=null) {
            System.out.println(book1.toString());
        } else {
            System.out.println("Book id not found");
        }
    }

    public static void borrowBooks() throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean flag1 = true;
        do {
            System.out.println("Enter by id student: ");
            String id = sc.nextLine();
            String result = StudentDAO.getInstance().checkIdStudent(id);
            if (result!=null) {
                flag1 = false;
                break;
            }
            System.out.println("Student id not found");
        }while (flag1);

        boolean flag2 = true;
        do {
            System.out.println("Please enter the name of the book you want to borrow ");
            String bookName = sc.nextLine();
            String result = BookDAO.getInstance().checkNameBook(bookName);
            if (result!=null) {
                flag2 = false;
                break;
            }
            System.out.println("Book name not found");
        }while (flag2);

    }

}
