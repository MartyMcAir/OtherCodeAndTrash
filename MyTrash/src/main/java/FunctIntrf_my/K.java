/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctIntrf_my;

/**
 *
 * @author MartyMcAir
 */
public class K implements IStatic {

    public static void main(String[] args) {
        K k = new K(); // Привет
        IStatic.print(); // Привет 
        IStatic intr = new K();
        System.out.println("строка из метода интерфесной переменной: " + intr.getString());
        System.out.println("строка из метода объектной переменной класса К: " + k.getString());
        System.out.println("Константа из объектной переменной класса К: " + k.STR);
        System.out.println("константа из интерфесной переменной: " + intr.STR2);
    }

    public K() {
        IStatic.test();
    }

    @Override
    public String getString() {
        return STR;
    }
}
