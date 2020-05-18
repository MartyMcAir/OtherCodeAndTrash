/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Mix;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MartyMcAir
 */
public class MySQLConnectionPool {
    private Connection cn;

    public MysqlDataSource setMysql(String DataBaseName) throws SQLException{
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setPort(3310);
        ds.setDatabaseName(DataBaseName);
        ds.setUser("test_user");
        ds.setPassword("123689");

        ds.setCharacterEncoding("utf8");
        ds.setServerTimezone("UTC");
        ds.setVerifyServerCertificate(false);
        ds.setUseSSL(false);
        return ds;
        
    }

    public Connection getConnect(String DataBaseName) {
        if (cn == null) {
            try {
                cn = setMysql(DataBaseName).getConnection();
            } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
            }
        }
        return cn;
    }

    public void Disconnect() throws SQLException{
        if (cn != null) {
            try {
                cn.close();
                cn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Example
    public static void main(String[] args) throws SQLException{          
        // new way
        String db2 = "`catalogPuZer2`";
        final String SQL_CREATE_DB2 = "CREATE DATABASE IF NOT EXISTS" + db2 +
                "DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci";
        
        MySQLConnectionPool cpd = new MySQLConnectionPool();
        Connection new_con = cpd.getConnect("z_test");

        Statement stmt2=null;
        
        try { stmt2 = new_con.createStatement(); 
        stmt2.executeUpdate(SQL_CREATE_DB2);
        System.out.println("База данных создана"); 
        } catch (SQLException e) { 
            System.out.println("Ошибка: " + e.getMessage());
        } finally { 
            try { 
                if (stmt2 != null) stmt2.close(); 
            } catch (SQLException e) {} 
            
            try { if (new_con != null) new_con.close(); 
            } catch (SQLException e) {}
        stmt2 = null; new_con = null; 
        }
    }
}
