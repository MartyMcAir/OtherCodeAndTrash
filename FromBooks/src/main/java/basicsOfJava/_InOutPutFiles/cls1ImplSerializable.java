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
public class cls1ImplSerializable implements Serializable{
    private static final long serialVersionUID=4159958489342586369L;
    private int x;
    private String str = "string";
    
    cls1ImplSerializable(){   }
    cls1ImplSerializable(int x){
        this.x=x;
    }
    
    public void setX(int x){
        this.x=x;
    }
    public int getX(){
        return this.x;
    }
    public int get13(){
        return 13;
    }
    public String getStr(){
        return str;
    }
}
