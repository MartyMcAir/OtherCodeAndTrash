/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_baeldung;

/**
 *
 * @author MartyMcAir
 */
public class Z_baeldung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("ff");
        // USED
//        @LoadRunner
//        public whenCalledgetConnection_thenCorrect
//        
//            () {
//    ConnectionPool connectionPool = BasicConnectionPool
//                    .create("jdbc:h2:mem:test", "user", "password");
//
//            assertTrue(connectionPool.getConnection().isValid(1));
//        }




// XZ
//        @Override
//
//     Connection getConnection() throws SQLException {
//        if (connectionPool.isEmpty()) {
//            if (usedConnections.size() < MAX_POOL_SIZE) {
//                connectionPool.add(createConnection(url, user, password));
//            } else {
//                throw new RuntimeException(
//                        "Maximum pool size reached, no available connections!");
//            }
//        }
//
//        Connection connection = connectionPool
//                .remove(connectionPool.size() - 1);
//        usedConnections.add(connection);
//        return connection;


// XZ 2
//public void shutdown() throws SQLException {
//    usedConnections.forEach(this::releaseConnection);
//        Iterable<Connection> connectionPool = null;
//    for (Connection c : connectionPool) {
//        c.close();
//    }
//  
//
//    }
//
//    private static class usedConnections {
//
//        public usedConnections() {
//        }


    }
    
}
