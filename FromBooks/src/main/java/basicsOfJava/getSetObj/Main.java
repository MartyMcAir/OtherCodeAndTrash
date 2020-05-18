/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.getSetObj;

/**
 *
 * @author MartyMcAir
 */
public class Main {
    public static void main(String[] args){
        Child1 chl1 = new Child1();
        GetMe gtm = chl1.getObj();
        System.out.println( gtm.str); // Объект получен!
        System.out.println();
        
        // в Child2 метод getObj() способен вернуть любой тип объекта
        // который был setObj(), но для использования необходимо делать
        // приведение типа к необходимому классу
        Child2 chl2 = new Child2();
        chl2.setObj(new SetAndGetMe());
        SetAndGetMe sagm = (SetAndGetMe) chl2.getObj();
        System.out.println(sagm.str);   // бъект добавлен и получен
    }
}
