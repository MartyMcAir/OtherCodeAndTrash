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
public class A implements iRead{

    @Override
    public String read() {
        System.out.println("метод вызван внутри A класса");
        return "строка 1 _ из A класса";
    }
    
}
