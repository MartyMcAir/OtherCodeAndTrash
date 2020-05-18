/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.GenericInterf_Base;

/**
 *
 * @author MartyMcAir
 */
public class Box {
    Object obj;
    
    public void setObj(Object obj){
        this.obj=obj;
    }
    public Object getObj(){
        return this.obj;
    }
    
    public void showObj(){
        System.out.println("ваш объект: "+obj);
    }
    
    // Метод проверки типа полученного объекта
    public void showObjType(){
        String res="";
        if(this.obj instanceof Integer){
            res="Integer";
        } else if(this.obj instanceof String){
            res="String";
        } else if(this.obj.getClass() == Double.class){
            res="Double";
        } else{
            res="тип вашего объекта: "+this.obj.getClass();
        }
        System.out.println(res);
    }
}
