/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Mix;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MartyMcAir
 */
public class MySQLdbCRUD implements intrfCRUD{
    MySQLConnectionPool cpd = new MySQLConnectionPool();
    Connection new_con;
    Statement stmt=null;
    ResultSet rs = null;

    public void setDB(String DataBaseName){
    this.new_con = cpd.getConnect(DataBaseName);
    }
    
    public Connection getDB(){
    return this.new_con;
    }
    
    @Override    
    public void create(String DataBaseName){
        final String SQL_CREATE_DB = "CREATE DATABASE IF NOT EXISTS " + DataBaseName +
                " DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci";
        try { stmt = new_con.createStatement(); 
        stmt.executeUpdate(SQL_CREATE_DB);
        System.out.println("Создана База Данных: " + DataBaseName); 
        } catch (SQLException e) { 
            System.out.println("Ошибка: " + e.getMessage());
        } finally { 
            try { 
                if (stmt != null) stmt.close(); 
            } catch (SQLException e) {} 
            
            try { if (new_con != null) new_con.close(); 
            } catch (SQLException e) {}
        stmt = null; new_con = null; 
        } 
    }

    @Override    
    public void delete(String DataBaseName){
        final String SQL_CREATE_DB = "DROP DATABASE " + DataBaseName;
        try { stmt = new_con.createStatement(); 
        stmt.executeUpdate(SQL_CREATE_DB);
        System.out.println("Удалена База Данных: " + DataBaseName); 
        } catch (SQLException e) { 
            System.out.println("Ошибка: " + e.getMessage());
        } finally { 
            try { 
                if (stmt != null) stmt.close(); 
            } catch (SQLException e) {} 
            
            try { if (new_con != null) 
                    new_con.close(); 
            } catch (SQLException e) {}
        stmt = null; new_con = null; 
        } 
    }

    @Override
    public void update(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void getSQLversion(){
        try {
            stmt = new_con.createStatement();
            rs = stmt.executeQuery("SELECT version()");
            if (rs.next()) {
            System.out.println("Database Version : " + rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                rs.close();
                }
                if (stmt != null) {
                stmt.close();
                }
                if (new_con != null) {
                new_con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
    }
    
    public void executeUpdate(String SQL){
        final String SQL_CREATE_DB = SQL;
        try { stmt = new_con.createStatement(); 
        stmt.executeUpdate(SQL_CREATE_DB);
        System.out.println("Выполнен метод stmt.executeUpdate с запросом: " + SQL); 
        } catch (SQLException e) { 
            System.out.println("Ошибка: " + e.getMessage());
        } finally { 
            try { 
                if (stmt != null) stmt.close(); 
            } catch (SQLException e) {} 
            
            try { if (new_con != null) 
                    new_con.close(); 
            } catch (SQLException e) {}
        stmt = null; new_con = null; 
        } 
    }
    
    // Example
    public static void main(String[] args){
        MySQLdbCRUD mysqlCrud = new MySQLdbCRUD();
        mysqlCrud.setDB("z_test");
        mysqlCrud.executeUpdate("DROP DATABASE catalog88");
    }

}
