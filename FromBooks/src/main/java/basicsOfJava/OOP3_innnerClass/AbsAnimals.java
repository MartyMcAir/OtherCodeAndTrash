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
abstract class AbsAnimals {
    String sound;
    
    AbsAnimals(String sound){
        this.sound=sound;
    }
    
    abstract public void doAny();
    
    public void doSound(){
        System.out.println("делает: "+sound);
    }
}
