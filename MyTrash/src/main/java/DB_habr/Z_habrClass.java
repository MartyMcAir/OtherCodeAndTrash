/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_habr;

/**
 *
 * @author MartyMcAir
 */
public class Z_habrClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Экземпляр Connection доступен методу getPrepareStatement(String sql), который 
//в свою очередь доступен любому методу конкретного DAO класса. Стоит помнить, 
//что следует закрывать экземпляр PrepareStatement сразу после его отработки в 
//блоках finally, а возвращать соединение в пул returnConnectionInPool() в части
//логики системы, где был вызван метод.

        System.out.println("fff");
    }
    
}
