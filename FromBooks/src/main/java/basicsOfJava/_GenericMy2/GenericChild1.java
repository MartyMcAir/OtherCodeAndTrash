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
// Обобщенный класс может наследовать
// при этом первая буква у наследующего должна быть указана такая же как
// и у наследуемого класса после слова extends и имени класса
// Наследуем обобщенным классом обобщенный класс
public class GenericChild1 <T, B> extends GenericBox <T> {
    private B objB;
    
    // Переопределение метода GenericBox класса
    @Override
    public void showObj() {
        System.out.println("переопределенный метод из GenericChild1"
                + " и его B объект: "+ " "+objB);
    }
    
    // Функция обратного вызова метода из супер Класса
    public void callBackForSuperClass(){
        super.showObj();
    }
    
    GenericChild1(T objT, B objB){
        super(objT);
        this.objB=objB;
    }
    
    public void setB(B objB) {
        this.objB = objB;
    }
    public B getB() {
        return this.objB;
    }
    public void showB() {
        System.out.println("ваш объект: " + objB);
    }
}
