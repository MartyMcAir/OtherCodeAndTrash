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
public class C implements iWrite{

    @Override
    public void write(String s) {
        System.out.println(s);
        //System.out.println("метод вызван внутри С класса"); // работает
    }
    
}
