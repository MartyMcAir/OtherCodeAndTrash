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
public class Main {

    public static void main(String[] args) {
        clsMethods cls = new clsMethods();
        // cls.showScannerVariable2();
        // cls.showThrow();
        cls.showlog();
        
         runclsUSerException();
    }

    public static void runclsUSerException() {
        try {
            throw new clsUSerException("мое описание ошибки");
        } catch (clsUSerException e) {
            System.out.println(e.getMessage());
            //System.out.println(e.getCause());
        }
    }
}
