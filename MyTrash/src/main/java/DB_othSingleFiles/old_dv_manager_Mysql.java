/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_othSingleFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author MartyMcAir
 */
// Старый вариант подключения с использованием DriverManager
public class old_dv_manager_Mysql {
    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3310/z_test?characterEncoding=utf8";
    private static final String USERNAME = "test_user";
    private static final String PASSWORD = "123689";
    private static final String MAX_POOL = "250"; // кол-во запросов

    // init connection object
    private Connection connect;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
// вместо: ?serverTimezone=UTC&verifyServerCertificate=false&useSSL=false
            properties.setProperty("serverTimezone", "UTC");            
            properties.setProperty("useSSL", "false");
            properties.setProperty("verifyServerCertificate", "false");
            properties.setProperty("autoReconnect", "true");
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        if (connect == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connect = DriverManager.getConnection(DATABASE_URL, getProperties());
            } 
            /* *
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } /* */
            catch (ClassNotFoundException e) {
            System.out.println("Драйвер не найден");
            e.printStackTrace();
            System.exit(1);
            } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
            }
        }
        return connect;
    }

    // disconnect database
    public void disconnect() {
        if (connect != null) {
            try {
                connect.close();
                connect = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
/* *
String sql = "SELECT * FROM `stackoverflow`";
try {
    PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
    ... go on ...
    ... go on ...
    ... DONE ....
} catch (SQLException e) {
    e.printStackTrace();
} finally {
    mysqlConnect.disconnect();
} 
/* */
    
   /* Example */
   public static void main(String[] args) throws Exception{
    old_dv_manager_Mysql mysql = new old_dv_manager_Mysql();
    mysql.connect();
    
    // 
            String db = "`catalog8`";
        final String SQL_CREATE_DB = "CREATE DATABASE IF NOT EXISTS" + db +
                "DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci";

        final String SQL_DELETE_DB = "DROP DATABASE" + db;
        
        old_dv_manager_Mysql conn = new old_dv_manager_Mysql();
        Connection connect = conn.connect();
        
        Statement stmt=null;
        
        try { stmt = connect.createStatement(); 
        stmt.executeUpdate(SQL_DELETE_DB);
        System.out.println("База данных создана"); 
        } catch (SQLException e) { 
            System.out.println("Ошибка: " + e.getMessage());
        } finally { 
            try { 
                if (stmt != null) stmt.close(); 
            } catch (SQLException e) {} 
            
            try { if (connect != null) connect.close(); 
            } catch (SQLException e) {}
        stmt = null; connect = null; 
        }
   }
   
}