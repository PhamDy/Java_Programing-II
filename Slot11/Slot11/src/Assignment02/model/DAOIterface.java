package Assignment02.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOIterface<T> {

    void insert(T t) throws SQLException;

    T selectById(String id) throws SQLException;

    T selectByName(String name) throws SQLException;

    void delete(String id) throws SQLException;

    ArrayList<T> selectAll() throws SQLException;

}
