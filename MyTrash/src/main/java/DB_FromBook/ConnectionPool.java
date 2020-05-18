/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_FromBook;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MartyMcAir
 */
class ConnectionPool {
    private static final String DATASOURCE_NAME = "jdbc/testphones"; 
    private static DataSource dataSource; 
    static { 
        try { 
            Context initContext = new InitialContext(); 
            Context envContext = (Context) initContext.lookup("java:/comp/env"); 
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME); 
        } catch (NamingException e) { e.printStackTrace(); }
    } 

    static void close(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private ConnectionPool() { } 
    
    public static Connection getConnection() throws SQLException { 
        Connection connection = dataSource.getConnection(); 
        return connection; } // метод возвращения Connection в пул

}
