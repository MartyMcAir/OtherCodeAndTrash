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
public class Car {
    public String color;
    Car(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "{"
                + "color car='" + color + '\''
                + '}';
    }
}
