/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author MartyMcAir
 */
public class clsImplObjOut3 implements AutoCloseable{
    private OutputStream out;
    private BufferedOutputStream bufOut;
    private ObjectOutputStream objOut;
    
    clsImplObjOut3(OutputStream out, BufferedOutputStream bufOut){
        this.out=out;
        this.bufOut=bufOut;
    }
    clsImplObjOut3(OutputStream out, ObjectOutputStream objOut){
        this.out=out;
        this.objOut=objOut;
    }
    clsImplObjOut3(OutputStream out, BufferedOutputStream bufOut,
            ObjectOutputStream objOut){
        this.out=out;
        this.bufOut=bufOut;
        this.objOut=objOut;
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("\nВсе операции завершены.");
        if(objOut!=null){
            objOut.flush();
            objOut.close();
        }
        if(bufOut!=null){
            bufOut.flush();
            bufOut.close();
        }
        if(out!=null){
            out.flush();
            out.close();
        }
    }
}
