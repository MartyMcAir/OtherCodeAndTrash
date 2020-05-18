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
public class Mimpl implements iReadWrite{

    @Override
    public void showDef() {
        System.out.println("default метод iReadWrite интерфейса переопределен");
    }

    @Override
    public String read() {
        return " ";
    }

    @Override
    public void write(String s) {

    }
    
}
