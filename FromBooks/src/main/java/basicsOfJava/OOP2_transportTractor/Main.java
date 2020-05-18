/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.OOP2_transportTractor;

/**
 *
 * @author MartyMcAir
 */
public class Main {
    public static void main(String[] args){
        Bus bs = new Bus();
        bs.showOptions();
        System.out.println(bs.color);
        System.out.println();
        
        Bus bs2 = new Bus(bs.color, bs.fuel, bs.maxSpeed, 
                bs.doAny, bs.transport);
        bs2.showOptions();
        bs2.showGo();
        System.out.println();
        
        Tractor tr = new Tractor();
        Tractor tr2 = new Tractor(tr.color, tr.fuel, tr.maxSpeed, 
                tr.doAny, tr.transport);
        tr2.showOptions();
        tr2.showGo();
        
        ( (Transport) tr2 ).showGo(); // приведение к типу класса Transport не работает
        System.out.println("Строковое описание объекта Bus "+bs2.toString());
        System.out.println("переопределенн метод toString() объекта Tractor: "+tr.toString());
        System.out.println("получаем инфу1 об объекте: "+bs2.getClass());
        System.out.println("получаем инфу2 об объекте: "+bs2.getClass().getName());
        System.out.println("получаем инфу3 об объекте (суперКласс): "+bs2.getClass().getSuperclass().getName());
        
    }
}
