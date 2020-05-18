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
public class MySQLtableCRUD implements intrfCRUD{
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
    public void create(String table_name) {
        try { stmt = new_con.createStatement ();
        stmt.executeUpdate("CREATE TABLE " + table_name + 
            " (id_user mediumint(9) auto_increment, PRIMARY KEY (id_user), " + 
        //" UNIQUЕ КЕY (email), " +
            " email char (50), passw char (32) " + 
            " CHARACTER SET utf8 COLLATE utf8_bin);") ;
        // ")ENGINE=InnoDB DEFAULТ СНАRSЕТ=utf8") ;
        System.out.println("Создана Таблица: " + table_name); 
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage() );
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
    public void delete(String table_name) {
        try { stmt = new_con.createStatement ();
        stmt.executeUpdate("DROP TABLE " + table_name) ;
        // ")ENGINE=InnoDB DEFAULТ СНАRSЕТ=utf8") ;
        System.out.println("Удалена Таблица: " + table_name); 
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage() );
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
    public void update(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
