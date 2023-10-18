package mvcccrud;

import ui.ProductConsole;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MVCcrud {
    public static void main(String[] args) throws IOException, SQLException {

        ProductConsole pc = new ProductConsole();
        pc.start();

    }
}
