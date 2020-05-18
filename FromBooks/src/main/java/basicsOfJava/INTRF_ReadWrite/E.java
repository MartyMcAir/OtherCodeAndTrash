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
public class E implements iRead, iWrite{

    @Override
    public String read() {
        return "строка 3";
    }

    @Override
    public void write(String s) {
        System.out.println(s+ " Работает");
    }
    
}
