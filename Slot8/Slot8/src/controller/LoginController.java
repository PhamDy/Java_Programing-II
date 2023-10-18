package controller;

import dao.LoginDao;
import dao.LoginDaoImpl;
import entity.Users;

import java.sql.SQLException;

public class LoginController {
    LoginDaoImpl loginDao = new LoginDaoImpl();

    public String loginPreparedStatementController(Users user) throws SQLException {
        return loginDao.checkLoginPreparedStatement(user);
    }

}
