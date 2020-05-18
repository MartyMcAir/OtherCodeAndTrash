/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.tryCatch;

/**
 *
 * @author MartyMcAir
 */
public class clsUSerException extends RuntimeException{
    clsUSerException(){
        super("ошибка класса clsUSerException");
    }
    clsUSerException(String str){
        super("ошибка класса clsUSerException: "+str);
    }
    clsUSerException(String str, Throwable cause){
        super("ошибка класса clsUSerException: "+str, cause);
    }
    
}
