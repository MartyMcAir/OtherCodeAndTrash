/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_othSingleFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MartyMcAir
 */
public class A_mixSQLFromBooks {

    // DB = "test",
    String URL = "jdbc:mysql://localhost:3306/",
            ENCODE = "?characterEncoding=utf8",
            USER = "root", PASSW = "";

    public static void main(String[] args) throws SQLException {
        A_mixSQLFromBooks v_main = new A_mixSQLFromBooks();

        Connection con = v_main.connect("test");
        System.out.println("Соединение успешно установлено.");
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("ff");
    }

    public Connection connect(String DB) {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL + DB + ENCODE, USER, PASSW);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

}
