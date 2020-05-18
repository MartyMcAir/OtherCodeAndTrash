/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.*;

/**
 *
 * @author MartyMcAir
 */
public class clsImplCloseFull6 implements AutoCloseable {

    private OutputStream out;
    private BufferedOutputStream bufOut;
    private InputStream in;
    private BufferedInputStream bufIn;
    private DataOutputStream dataOut;
    private DataInputStream dataIn;

    clsImplCloseFull6() {
    }

    // just out and in
    clsImplCloseFull6(OutputStream out, InputStream in) {
        this.out = out;
        this.in = in;
    }

    // just out 2
    clsImplCloseFull6(OutputStream out, BufferedOutputStream bufOut) {
        this.out = out;
        this.bufOut = bufOut;
    }

    // just in 2
    clsImplCloseFull6(InputStream in, BufferedInputStream bufIn) {
        this.in = in;
        this.bufIn = bufIn;
    }

    //just out and in 2x2
    clsImplCloseFull6(OutputStream out, BufferedOutputStream bufOut,
            InputStream in, BufferedInputStream bufIn) {
        this.out = out;
        this.bufOut = bufOut;
        this.in = in;
        this.bufIn = bufIn;
    }

    //out 3
    clsImplCloseFull6(OutputStream out, BufferedOutputStream bufOut,
            DataOutputStream dataOut) {
        this.out = out;
        this.bufOut = bufOut;
        this.dataOut = dataOut;
    }

    // in 3
    clsImplCloseFull6(InputStream in, BufferedInputStream bufIn,
            DataInputStream dataIn) {
        this.in = in;
        this.bufIn = bufIn;
        this.dataIn = dataIn;
    }

    // All 6
    clsImplCloseFull6(OutputStream out, BufferedOutputStream bufOut,
            DataOutputStream dataOut, InputStream in,
            BufferedInputStream bufIn, DataInputStream dataIn) {
        this.out = out;
        this.bufOut = bufOut;
        this.in = in;
        this.bufIn = bufIn;
        this.dataOut = dataOut;
        this.dataIn = dataIn;
    }

    @Override
    public void close() throws Exception {
        System.out.println("\nВсе операции завершены.");
        if (dataOut != null) {
            if (bufOut != null) {
                dataOut.flush();
            }
            dataOut.close();
        }
        if (bufOut != null) {
            bufOut.flush();
            bufOut.close();
        }
        if (out != null) {
            out.close();
        }
        if (dataIn != null) {
            dataIn.close();
        }
        if (bufIn != null) {
            bufIn.close();
        }
        if (in != null) {
            in.close();
        }
    }

}
