/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.lyambdaIntrf2;

/**
 *
 * @author MartyMcAir
 */
public class A {
    private int x=10;
    public void printOnClick(){
        System.out.println("Нажата кнопка. x= "+this.x);
        this.x++;
    }

    public void showAny(){
        System.out.println("Другой метод из А класса");
    }
}
