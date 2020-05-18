/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class A {

    private int x;
    private Date d;   // Изменяемый объект!

    public A(int x) {
        this.x = x;
        this.d = new Date();
    }

    public int getX() {
        return this.x;
    }

    public Date getD() {
        // Изменяемые объекты возвращаем только так!
        // через приведение к типу (Date)
        return (Date) this.d.clone();
    }
    // setter времени

    public void newDate(long time) {
        this.d.setTime(time);
    }

    @Override // переопределяем метод клонирования объекта
    public A clone() {
        A obj = null;
        try {
            obj = (A) super.clone(); // Вызов метода из класса Object
            obj.d = (Date) d.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return obj;
    }

//    public A clone() throws CloneNotSupportedException {
//        A obj = (A) super.clone(); // Вызов метода из класса Object
//
//        obj.d = (Date) this.d.clone();
//        return obj;
//    }
}
