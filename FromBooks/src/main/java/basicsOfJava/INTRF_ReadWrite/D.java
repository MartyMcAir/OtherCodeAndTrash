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
public class D {
    private iRead ir;
    private iWrite iw;
    private String str="";
    
    public D(iRead r, iWrite w){
        this.ir=r;
        this.iw=w;
        
        // при отправке в данный конструктор интерф перменной
        // c присвоенной ей экземпляром А класса
        // строка 1 из А класса
        this.str=ir.read(); // Получаем данные через метод read() А класса 
        
        // А если в конструктор попал B класс тогда его метод read()
    }
    
    public void change(){
        this.str=this.str.toUpperCase(); // обрабатываем данные
    }
    
    public void print(){
        this.iw.write(this.str);  // выводим данные
    }

}
