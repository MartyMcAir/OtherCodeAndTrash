/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon2;

/**
 *
 * @author MartyMcAir
 */
public class Author {
    public String name;
    Author(String name){
        this.name=name;
    }
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
}
