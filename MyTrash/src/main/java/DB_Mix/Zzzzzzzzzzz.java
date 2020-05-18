/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Mix;

import java.sql.SQLException;

/**
 *
 * @author MartyMcAir
 */
public class Zzzzzzzzzzz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        MySQLtableCRUD mysql = new MySQLtableCRUD();
//        mysql.setDB("z_test");
//        mysql.create("puzoz888");
            
        MySQLdbCRUD mysqlDB = new MySQLdbCRUD();
        mysqlDB.setDB("z_test");
        String SQL = "DROP TABLE puzo";
        mysqlDB.executeUpdate(SQL);
                
//          MySQLConnectionPool dbCRUD = new MySQLConnectionPool("z_test");
//    Connection con = MyClass.connect("catalog");
//      Statement stmt = null;
//      try {
//         stmt = con.createStatement();
//         stmt.executeUpdate("INSERT INTO `user` (`email`, `passw`)"
//            + " VALUES ('user2@mail.ru', 'пароль')",
//            Statement.RETURN_GENERATED_KEYS);
//         int index = -1;
//         ResultSet rs = stmt.getGeneratedKeys();
//         if (rs.next()) index = rs.getInt(1);
//         System.out.println("Индекс новой записи: " + index);
//         if (rs != null) rs.close();
//      } catch (SQLException e) {
//         System.out.println("Ошибка: " + e.getMessage());
//      }
//      finally {
//         try { if (stmt != null) stmt.close(); }
//         catch (SQLException e) {}
//         try { if (con != null)  con.close(); }
//         catch (SQLException e) {}
//         stmt = null; con = null;
//      }

    }
    
}
