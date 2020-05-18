/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.Serializable;

/**
 *
 * @author MartyMcAir
 */
public class cls2ImplSerializable implements Serializable{
    private static String strStatic ="strStatic";
    private int number;
    private transient String strTransient="transient secret";
    
    cls2ImplSerializable(){   }
    cls2ImplSerializable(int number){
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number=number;
    }
    
    public String getTransient(){
        return strTransient;
    }
    public static void showFromSticMethod(){
        System.out.println(strStatic);
    }
    public String getStrStatic(){
        return strStatic;
    }
}
