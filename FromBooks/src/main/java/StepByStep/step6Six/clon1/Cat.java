/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon1;

import java.io.Serializable;

/**
 *
 * @author MartyMcAir
 */
public class Cat implements Serializable {
    private String name;
    private String color;
    private int age;
    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Cat{"
                + "name='" + name + '\''
                + ", color='" + color + '\''
                + ", age=" + age
                + '}';
    }
}
