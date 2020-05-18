/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Wrapper;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MartyMcAir
 */
public class DBconnect {
    public static Connection cn = null;

    public static MysqlDataSource getDataSource(String db) throws SQLException{
        MysqlDataSource ds = new MysqlDataSource();
        ds.setDatabaseName(db);
        ds.setUser("test_user");
        ds.setPassword("123689");
        ds.setPort(3310);
        ds.setServerName("localhost");
        ds.setUseSSL(false);
        ds.setCharacterEncoding("utf8");
        ds.setServerTimezone("UTC");
        ds.setVerifyServerCertificate(false);
        return ds;
    }
    
    public static Connection getConnect(String db) throws SQLException{
        cn = getDataSource(db).getConnection();
        return cn;
    }
    
    public void Disconnect() throws SQLException{
    cn.close();
    }
}
