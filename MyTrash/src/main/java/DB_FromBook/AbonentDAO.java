/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_FromBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MartyMcAir
 */
public class AbonentDAO extends AbstractDAO<Integer, Abonent> {

    public static final String SQL_SELECT_ALL_ABONENTS = "SELECT * FROM phonebook";
    public static final String SQL_SELECT_ABONENT_BY_LASTNAME = "SELECT idphonebook, phone FROM phonebook WHERE lastname=?";

    /* New */
    public AbonentDAO(Connection connection) {
        super(connection);
    }

    /* err *
    public AbonentDAO( ) {
        this.connector = new WrapperConnector();
    } /* */
    @Override
    public List<Abonent> findAll() {
        List<Abonent> abonents = new ArrayList<>();
        Connection cn = null;
//        Statement st = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.getConnection();
            //st = cn.createStatement();
//            st = (Statement) cn.createStatement();
            ResultSet resultSet = null;
//            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_ABONENTS); 
//            ResultSet resultSet = st.execute(SQL_SELECT_ALL_ABONENTS);
            while (resultSet.next()) {
//        Abonent abonent = new Abonent();
                Abonent abonent = new Abonent("", 1, new char[]{'a', 'b', 'c'});
                abonent.setId(resultSet.getInt("idphonebook"));
                abonent.setPhone(resultSet.getInt("phone"));
                abonent.setLastName(resultSet.getString("lastname"));
                abonents.add(abonent);
            }
        } catch (Exception e/**
                 * SQLException e /*
                 */
                ) {
            System.err.println("SQL exception (request or table failed): "/**/ + e/**/);
        } finally {
            close(st); // код возвращения экземпляра Connection в пул
//            this.closeStatement(st); // или вот это юзать? 
        }
        return abonents;

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override // Integer вместо int
    public Abonent findEntityById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Abonent entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Abonent entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Abonent update(Abonent entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // собственный метод DAO 
    public Abonent findAbonentByLastName(String name) {
//        Abonent abonent = new Abonent();
        Abonent abonent = new Abonent("", 1, new char[]{'a', 'b', 'c'});
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ABONENT_BY_LASTNAME);
            st.setString(1, name);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            abonent.setId(resultSet.getInt("idphonebook"));
            abonent.setPhone(resultSet.getInt("phone"));
            abonent.setLastName(name);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            close(st); // код возвращения экземпляра Connection в пул 
        }
        return abonent;
    }

    // NEW
    private void close(PreparedStatement st) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
