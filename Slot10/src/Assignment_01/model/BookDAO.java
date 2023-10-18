package Assignment_01.model;

import Assignment_01.dao.DBConnection;
import Assignment_01.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO implements DAOInterface<Book> {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;

    public static BookDAO getInstance() {
        return new BookDAO();
    }

    @Override
    public void insert(Book book) throws SQLException {
        connection = DBConnection.getConnection();

        String query ="INSERT INTO book(id, name, author, publisher, category, price, dateAdd, status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getId());
        preparedStatement.setString(2, book.getName());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setString(4, book.getPublisher());
        preparedStatement.setString(5, book.getCategory());
        preparedStatement.setDouble(6, book.getPrice());
        preparedStatement.setDate(7, book.getDateAdd());
        preparedStatement.setBoolean(8, book.isStatus());

        preparedStatement.executeUpdate();

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);


    }

    @Override
    public Book selectById(String id) throws SQLException {
        Book book = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM book WHERE id = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            book.setId(resultSet.getString(1));
            book.setName(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setPublisher(resultSet.getString(4));
            book.setCategory(resultSet.getString(5));
            book.setPrice(resultSet.getDouble(6));
            book.setDateAdd(resultSet.getDate(7));
            book.setStatus(resultSet.getBoolean(8));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return book;
    }

    @Override
    public Book selectByName(String name) throws SQLException {
        Book book = null;
        connection = DBConnection.getConnection();

        String query ="SELECT * FROM book WHERE name = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            book.setId(resultSet.getString(1));
            book.setName(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setPublisher(resultSet.getString(4));
            book.setCategory(resultSet.getString(5));
            book.setPrice(resultSet.getDouble(6));
            book.setDateAdd(resultSet.getDate(7));
            book.setStatus(resultSet.getBoolean(8));
        }

        DBConnection.closePreparedstatement(preparedStatement);
        DBConnection.closeConnection(connection);

        return book;
    }

    @Override
    public ArrayList<Book> selectAll() throws SQLException {
        Book book = new Book();
        ArrayList<Book> list = new ArrayList<>();

        connection = DBConnection.getConnection();

        String query ="SELECT * FROM book";
        preparedStatement = connection.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            book.setId(resultSet.getString(1));
            book.setName(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setPublisher(resultSet.getString(4));
            book.setCategory(resultSet.getString(5));
            book.setPrice(resultSet.getDouble(6));
            book.setDateAdd(resultSet.getDate(7));
            book.setStatus(resultSet.getBoolean(8));
            list.add(book);
        }

        return list;
    }

    public String checkNameBook(String name) throws SQLException{
        connection = DBConnection.getConnection();
        String check = null;
        String query ="SELECT name FROM book WHERE name = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);

        System.out.println(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            check = resultSet.getString("name");
        }

        return check;
    }
}
