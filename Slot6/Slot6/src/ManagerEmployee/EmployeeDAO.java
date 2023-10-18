package ManagerEmployee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO<T> {
     int insert(T t) throws SQLException;

     int update(T t) throws SQLException;

     int delete(T t) throws SQLException;

     ArrayList<T> selectAll() throws SQLException;

     T selectById(T t) throws SQLException;

}
