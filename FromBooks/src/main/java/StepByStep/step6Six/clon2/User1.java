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
public class User1 implements Cloneable{
    private String name;
    private int age;
    private String[] strArr = {"line1","line2","lin3",};
    void setStrArrByIndex(int index, String str){
        this.strArr[index]=str;
    }
    void setStrArr(String[] arr){
        this.strArr=arr;
    }
    String[] getStrArr(){
        return this.strArr;
    }
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
    public User1 clone() throws CloneNotSupportedException{
        User1 obj = null;
        try{
            obj = (User1) super.clone();
//            obj = (User1) new User1();
//            obj.strArr = (String[]) obj.strArr.clone();
        }catch(Exception e){
            System.err.println("err: "+e.getMessage());
        }
        return obj;
    }
}
