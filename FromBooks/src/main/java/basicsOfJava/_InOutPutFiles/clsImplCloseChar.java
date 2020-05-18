/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.BufferedOutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author MartyMcAir
 */
public class clsImplCloseChar implements AutoCloseable{
    private Writer wr;
    private Reader rd;
    private BufferedOutputStream bufOut;
    
    clsImplCloseChar(){}
    clsImplCloseChar(Writer wr){
        this.wr=wr;
    }
    clsImplCloseChar(Reader rd){
        this.rd=rd;
    }
    clsImplCloseChar(Writer wr, Reader rd){
        this.wr=wr;
        this.rd=rd;
    }
    clsImplCloseChar(Writer wr, Reader rd, BufferedOutputStream bufOut){
        this.wr=wr;
        this.rd=rd;
        this.bufOut=bufOut;
    }
    @Override
    public void close() throws Exception {
        System.out.println("\nВсе операции завершены.");
        if(wr!=null){
            if(bufOut!=null){
                bufOut.flush();
                wr.flush();
                bufOut.close();
            }
            wr.close();
        }
        if(rd!=null){
            rd.close();
        }
    }
    
}
