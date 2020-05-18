/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.ArrObj;

/**
 *
 * @author MartyMcAir
 */
public class A {

    public int x;
    public String s = "";

    A() {
    }
    
    // Перегруженный конструктор
    A(String s) {
        this.s = s;
    }
    
    public void showAny(){
        System.out.println("метод А класса");
    }
}
