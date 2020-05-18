/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.OOP3_innnerClass;

/**
 *
 * @author MartyMcAir
 */
public class Cat extends AbsAnimals{

    public Cat(String sound) {
        super(sound);
    }

    @Override
    public void doAny() {
        System.out.println("кошачии царапаются");
    }
    
}
