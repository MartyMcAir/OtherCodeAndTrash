/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_othSingleFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author MartyMcAir
 */
public class ConnectionPool {

    public static void main(String[] args) throws SQLException {
        ConnectionPool cnt = new ConnectionPool("jdbc:mysql://localhost:3310/z_test?characterEncoding=utf8&databaseName=z_test&username=test_user&password=123689&ServerTimezone=UTC&UseSSL=false&VerifyServerCertificate=false", "com.mysql.cj.jdbc.Driver", 1);
        Connection cn = cnt.retrieve();

        //cnt.putback(Connection cn);
        //cn.close();
    }

    // Первый будет содержать список доступных для использования соединений, 
    //второй список используемых в любой момент времени.
    private Vector<Connection> availableConns = new Vector<Connection>();
    private Vector<Connection> usedConns = new Vector<Connection>();
    private String url;

    // URL: jdbc:sqlserver://192.168.0.1;databaseName=dbname;username=username;password=pwd
    public ConnectionPool(String url, String driver, int initConnCnt) {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.url = url;
        for (int i = 0; i < initConnCnt; i++) {
            availableConns.addElement(getConnection());
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Итак, мы имеем вектор availableConns, заполненный Connection'ами 
    // в количестве initConnCnt штук, ни один из которых пока не используется
    // непосредственно по назначению, т.е. для доступа к бд. 
    // Теперь напишем функцию retrieve, эта функция забирает из availableConns
    // очередной Connection и добавляет его в usedConns, затем возвращает 
    // это соединение, тем самым он становится используемым:
    public synchronized Connection retrieve() throws SQLException {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        // Логика понятна: сначала мы проверяем, есть ли свободные соединения, 
        // если нет, то мы создаем новое подключение, если есть, то мы извлекаем
        // последний элемент из availableConns и удаляем его из вектора свободных 
        //соединений. Затем мы только что созданное соединение или извлеченное 
        // из списка свободных добавляем в список используемых строкой 
        usedConns.addElement(newConn);
        return newConn; // и возвращаем это соединение.
    }

    // Доступ то многопоточный, вдруг двум потокам выделится одно и то же 
    // соединение! Когда соединение становится не нужным, то мы выполняем 
    // обратную операцию, иначе говоря putback:
    public synchronized void putback(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the usedConns array");
            }
        }
    }

    // функция для получения количества свободных соединений
    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}
