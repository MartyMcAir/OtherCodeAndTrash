/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon1;

/**
 *
 * @author MartyMcAir
 */
public class Person implements Cloneable {
    String name;
    int age;
    Car car;
    Person(Car car, int age, String name) {
        this.car = car;
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name + " {"
                + "age=" + age
                + ", car=" + car
                + '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
