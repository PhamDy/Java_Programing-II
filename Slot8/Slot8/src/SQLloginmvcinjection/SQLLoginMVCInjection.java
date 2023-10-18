package SQLloginmvcinjection;

import ui.LoginConsole;

import java.io.IOException;
import java.sql.SQLException;

public class SQLLoginMVCInjection {
    public static void main(String[] args) throws IOException, SQLException {
        LoginConsole loginConsole = new LoginConsole();
        loginConsole.start();
    }
}
