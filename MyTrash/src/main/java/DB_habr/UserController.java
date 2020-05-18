/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_habr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MartyMcAir
 */
public class UserController extends AbstractController<User, Integer>{
    public static final String SELECT_ALL_USERS = "SELECT * FROM SHEMA.USER";
    
    @Override
    public List<User> getAll() {
        List<User> lst = new LinkedList<>();
// вызываем наследуемый метод getPrepareStatement() из AbstractController класса
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_USERS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                User usr = new User();
                usr.setId(rs.getInt(1));
                usr.setName(rs.getString(2));
                lst.add(usr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return lst;
    }

    @Override
    public User getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
    
    @Override
    public User update(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
