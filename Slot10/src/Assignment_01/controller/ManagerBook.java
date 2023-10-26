package Assignment_01.controller;

import Assignment_01.entity.Book;
import Assignment_01.entity.Student;
import Assignment_01.model.BookDAO;
import Assignment_01.model.StudentDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    private static List<Student> students = new ArrayList<>();

    public static void borrowBooks() throws SQLException {
        String student_id = "";
        String book_name = "";

        Scanner sc = new Scanner(System.in);
        boolean flag1 = true;
        do {
            System.out.println("Enter by id student: ");
            student_id = sc.nextLine();
            String result = StudentDAO.getInstance().checkIdStudent(student_id);
            if (result!=null) {
                flag1 = false;
                break;
            }
            System.out.println("Student id not found");
        }while (flag1);

        boolean flag2 = true;
        do {
            System.out.println("Please enter the name of the book you want to borrow ");
            book_name = sc.nextLine();
            String result = BookDAO.getInstance().checkNameBook(book_name);
            if (result!=null) {
                flag2 = false;
                break;
            }
            System.out.println("Book name not found");
        }while (flag2);

        System.out.println("Successfully lend books to students");

        Book book = new BookDAO().getInstance().selectByName(book_name);
        Student student1 = StudentDAO.getInstance().selectById(student_id);
        boolean check = false;

        for (Student s: students
             ) {
            if (s.getId().equals(student1.getId())){
                s.addBook(book);
                check = true;
                break;
            }
        }
        if (!check){
            student1.addBook(book);
            students.add(student1);
        }

    }

    public static void displayBookByStudenId() throws SQLException{
        Scanner sc = new Scanner(System.in);
        String student_id = "";
        boolean flag1 = true;
        do {
            System.out.println("Enter by id student: ");
            student_id = sc.nextLine();
            String result = StudentDAO.getInstance().checkIdStudent(student_id);
            if (result!=null) {
                flag1 = false;
                break;
            }
            System.out.println("Student id not found");
        }while (flag1);

        for (Student s: students
             ) {
            if (s.getId().equals(student_id)){
                System.out.println(s.toStringBook());
            }
        }

    }

}
