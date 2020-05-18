/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._GenericMy2;

/**
 *
 * @author MartyMcAir
 */
// Наследуем обычным классом обобщенный класс
public class Child2ForGeneric<T> extends GenericBox<T>{
    private String str;
    
    Child2ForGeneric(T obj){
        super(obj);
    }
    
    public void setStr(String str){
        this.str=str;
    }
    public String getStr(){
        return this.str;
    }
    public void showStr(){
        System.out.println("ваша перменная строка: "+str);
    }
    
    // Переопределение метода GenericBox класса
    @Override
    public void showObj() {
        System.out.println("переопределенный метод из GenericChild1"
                + " и его str переменная строка: "+ " "+str);
    }
    
    // Функция обратного вызова метода из супер Класса
    public void callBackForSuperClass(){
        super.showObj();
    }
}
