/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.INTRF_ReadWrite;

/**
 *
 * @author MartyMcAir
 */
public class G implements iReadWrite{

    @Override
    public String read() {
        return "строка 4";
    }

    @Override
    public void write(String s) {
        System.out.println(s +" из класса реализующего интерфеса iReadWrite"
                + " который extends iRead, iWrite");
        System.out.println(G.MY_CONST);
    }
    
    public void runStatFromIntrf(){
        System.out.println("вызывается метод интерфейса из метода класса"
                + " реализующего его");
        iReadWrite.showStat();
    }
    
}
