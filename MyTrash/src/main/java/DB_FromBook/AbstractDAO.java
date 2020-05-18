/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_FromBook;

//import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author MartyMcAir
 */
public abstract class AbstractDAO<K, T extends EntityMy> {

    //public abstract T findEntityById(K id);
    //public abstract boolean delete(K id);
    protected WrapperConnector connector;

    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> findAll();

    public abstract T findEntityById(int id);

    public abstract boolean delete(int id);

    public abstract boolean delete(T entity);

    public abstract boolean create(T entity);

    public abstract T update(T entity);

//    public void close(Statement st) {
//        try {
//            if (st != null) {
//                st.close();
//            }
//        } catch (SQLException e) {
//            // лог о невозможности закрытия Statement 
//        }
//    }

    public void close() {
        connector.closeConnection();
    }

    protected void closeStatement(Statement statement) {
        connector.closeStatement(statement);
    }

    /* *
    public void close(Statement st){
    try{ if(st !=null){
        st.close();
        }
    } catch(SQLException e) {
        
    }
    
    } /* */
}
