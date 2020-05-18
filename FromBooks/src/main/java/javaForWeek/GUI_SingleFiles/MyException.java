/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaForWeek.GUI_SingleFiles;

/**
 *
 * @author MartyMcAir
 */
public class MyException extends Exception{
    private int code;
    MyException(int n){
        super();
        code=n;
    }
    
    @Override
    public String toString(){
        String msg="код ошибки: "+code;
        return msg;
    }
}
