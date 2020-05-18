/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_baeldung2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MartyMcAir
 */
public interface ConnectionPool {
    Connection getConnection() throws SQLException;
    
    boolean releaseConnection(Connection connection);
    
    List<Connection> getConnectionPool();
    
    int getSize();
    
    String getUrl();
    
    String getUser();

    String getPassword();
    
    void shutdown() throws SQLException;;
}
