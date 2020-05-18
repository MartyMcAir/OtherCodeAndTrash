/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Wrapper;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author MartyMcAir
 */
public class Z_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dbOne();
        dbTwo();
        dbThree();
    }
    
    public static void dbOne(){
            try {
        Connection cn = DBconnect.getConnect("z_test");
        Statement st = cn.createStatement();
        st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + "one" +
                " DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci");
        System.out.println("Таблица успешно создана");
        } catch (Exception e) {
        System.out.println("Ошибка!: " + e.getMessage());
        }
    }
    
    public static void dbTwo(){
            try {
        Connection cn = DBconnect.getConnect("z_test");
        Statement st = cn.createStatement();
        st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + "two" +
                " DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci");
        System.out.println("Таблица успешно создана");
        } catch (Exception e) {
        System.out.println("Ошибка!: " + e.getMessage());
        }
    }
    
    public static void dbThree(){
            try {
        Connection cn = DBconnect.getConnect("z_test");
        Statement st = cn.createStatement();
        st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + "three" +
                " DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci");
        System.out.println("Таблица успешно создана");
        } catch (Exception e) {
        System.out.println("Ошибка!: " + e.getMessage());
        }
    }
}
