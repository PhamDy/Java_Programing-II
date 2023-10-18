package dao;

import entity.Users;

import java.sql.SQLException;

public interface LoginDao {

    String checkLoginPreparedStatement(Users user) throws SQLException;
}
