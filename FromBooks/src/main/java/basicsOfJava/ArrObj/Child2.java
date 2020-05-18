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
public class Child2 extends A{
    
    Child2(){}
    
    Child2(String s) {
        super(s); // передаем значение  в конструктор суперКласса
    }
    
    public void show(){
        System.out.println("класс Child2");
    }
}
