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
public class User implements Cloneable{
    private String name;
    private int age;
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
    void setAge(int age){
        this.age=age;
    }
    int getAge(){
        return this.age;
    }
    public User clone() throws CloneNotSupportedException{
        User obj = null;
        try{
            obj = (User) super.clone();

        }catch(Exception e){
            System.err.println("err: "+e.getMessage());
        }
//        return (User) super.clone(); // краткая версия
        return obj;
    }
}
