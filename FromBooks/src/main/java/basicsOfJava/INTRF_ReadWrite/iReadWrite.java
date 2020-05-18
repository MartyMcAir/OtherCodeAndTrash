/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.INTRF_ReadWrite;

/**
 *
 * @author MartyMcAir
 */
public interface iReadWrite extends iRead, iWrite{
    String MY_CONST = "моя константа";
    
    // Пример статического метода
    static void showStat(){
        System.out.println("статический метод iReadWrite интерфейса");
    }
    
    // Пример метода по умолчанию
    default void showDef(){
        System.out.println("default метод iReadWrite интерфейса");   

    }
}
