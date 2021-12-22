/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_othSingleFiles.mysql_exp;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author MartyMcAir
 */
// По URL не работает
public class MySQL_DataSource_URL {
    // init database constants
    // private static final String DATABASE_URL = "jdbc:mysql://localhost:3310/z_test?characterEncoding=utf8";
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "test_user";
    private static final String PASSWORD = "123689";
    private static final String DB_NAME = "z_test";
    private static final String SERVER_NAME = "localhost";

    private final static String URL_NAME = "jdbc:mysql://localhost:3310/z_test" +
            "?useUnicode=true&amp;characterEncoding=utf8" +
            "&username=test_user&password=123689&ServerTimeZone=UTC&" +
            "UseSSL=false&VerifyServerCertificate=false";

    // init connection object
    private Connection connect;


    public static DataSource getMysqlDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        // Set dataSource Properties
//    dataSource.setServerName(SERVER_NAME);
//    dataSource.setPortNumber(3310);
//    dataSource.setDatabaseName(DB_NAME);
//    dataSource.setUser(USERNAME);
//    dataSource.setPassword(PASSWORD);

        //dataSource.setConnectTimeout(0);
        //dataSource.setConnectionAttributes(string);
        //dataSource.setCreateDatabaseIfNotExist(true);
        //dataSource.setSslMode("false");
        //dataSource.setSocketTimeout(0);
        //dataSource.setURL(string);

//    dataSource.setCharacterEncoding("utf8");
//    dataSource.setServerTimezone("UTC");
//    dataSource.setUseSSL(false);
//    dataSource.setVerifyServerCertificate(false);
//    dataSource.setAutoReconnect(true);

        dataSource.setURL(URL_NAME);
        return dataSource;
    }

    // connect database
    public Connection connectDS() {
        if (connect == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connect = getMysqlDataSource().getConnection();
            } catch (ClassNotFoundException e) {
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

    /* Example */
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Get connection from DataSource
            //conn = getMysqlDataSource().getConnection();
            //conn = MysqLdatSource1.getMysqlDataSource();
            MySQL_DataSource_URL mysql = new MySQL_DataSource_URL();
            conn = mysql.connectDS();
            stmt = conn.createStatement();
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
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
