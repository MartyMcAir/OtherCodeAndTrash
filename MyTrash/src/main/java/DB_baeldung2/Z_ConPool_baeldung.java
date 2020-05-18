/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_baeldung2;

import java.sql.SQLException;

/**
 *
 * @author MartyMcAir
 */
public class Z_ConPool_baeldung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //  No suitable driver
//        String url = "jdbc:mysql://localhost:3310/z_test?characterEncoding=utf8";
        String url = "com.mysql.cj.jdbc.Driver://localhost:3310/z_test?characterEncoding=utf8";
        String user = "test_user";
        String password = "123689";
        BasicConnectionPool.create(url, user, password);
    }

}
