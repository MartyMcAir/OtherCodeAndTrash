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
public class B implements iRead{
    private String s = "строка 2 из B класса";
    
    @Override
    public String read() {
        return this.s;
    }
    
    public void print(){
        System.out.println(this.s);
        System.out.println("метод вызван внутри B класса");
    }
}
