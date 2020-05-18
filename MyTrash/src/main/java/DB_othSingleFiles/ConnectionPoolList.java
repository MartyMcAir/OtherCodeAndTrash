package DB_othSingleFiles;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MartyMcAir
 */
public class ConnectionPoolList {

    public static void main(String[] args) throws SQLException {
        ConnectionPoolList cnpll = new ConnectionPoolList("z_test", 3);
        System.out.println("используемых соединений: " + cnpll.getUsedConnsCnt());
        System.out.println("доступных соединений: " + cnpll.getAvailableConnsCnt());
        Connection con = cnpll.retrieve();
        Statement stm = con.createStatement();

        try {
            stm.executeUpdate("CREATE DATABASE fugo");
            System.out.println("База данных создана");
            System.out.println("используемых соединений: " + cnpll.getUsedConnsCnt());
            System.out.println("доступных соединений: " + cnpll.getAvailableConnsCnt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //cnpll.putback(con);
        System.out.println("доступных соединений: " + cnpll.getAvailableConnsCnt());
        System.out.println("используемых соединений: " + cnpll.getUsedConnsCnt());
        cnpll.putback(con);
        System.out.println("после putback доступных соединений: " + cnpll.getAvailableConnsCnt());
        System.out.println("после putback используемых соединений: " + cnpll.getUsedConnsCnt());
    }

    private Vector<Connection> availableConns = new Vector<Connection>();
    private Vector<Connection> usedConns = new Vector<Connection>();
    private String db;

    private MysqlDataSource getDataSource() throws SQLException {
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

    public ConnectionPoolList(String db, int initConnCnt) throws SQLException {
//		try {
//			Class.forName(driver);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        this.db = db;
        for (int i = 0; i < initConnCnt; i++) {
            availableConns.addElement(getConnection());
        }
    }

    private Connection getConnection() throws SQLException {
        Connection conn = null;
//		try {
//			conn = getDataSource().getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        conn = getDataSource().getConnection();
        return conn;
    }

    public synchronized Connection retrieve() throws SQLException {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public synchronized void putback(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the usedConns array");
            }
        }
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }

    public int getUsedConnsCnt() {
        return usedConns.size();
    }
}
