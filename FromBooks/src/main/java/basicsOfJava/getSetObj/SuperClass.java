/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.getSetObj;

/**
 *
 * @author MartyMcAir
 */
public abstract class SuperClass {
    public String str, strSet;
    
    SuperClass(){}
    
    SuperClass(String str){
        this.str=str;
    }
    
    public void setStr(String strSet){
        this.strSet=strSet;
    }
    
    public String getStrSet(){
        return this.strSet;
    }
    
    public abstract Object getObj();
}
