/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author MartyMcAir
 */
public class clsImplObjIn3 implements AutoCloseable{
    private InputStream in;
    private BufferedInputStream bufIn;
    private ObjectInputStream objIn;
    clsImplObjIn3(InputStream in, BufferedInputStream bufIn){
        this.in=in;
        this.bufIn=bufIn;
    }
    clsImplObjIn3(InputStream in, ObjectInputStream objIn){
        this.in=in;
        this.objIn=objIn;
    }
    clsImplObjIn3(InputStream in, BufferedInputStream bufIn, 
            ObjectInputStream objIn){
        this.in=in;
        this.bufIn=bufIn;
        this.objIn=objIn;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Все операции завершены.");
        if(objIn!=null){
            objIn.close();
        }
        if(bufIn!=null){
            bufIn.close();
        }
        if(in!=null){
            in.close();
        }
    }
}
