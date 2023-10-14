package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOInterface<T> {

    public int insert(T t) throws SQLException;

    public int update(T t) throws SQLException;

    public int delete(T t) throws SQLException;

    public ArrayList<T> selectAll() throws SQLException;

    public T selectById(T t) throws SQLException;

}
