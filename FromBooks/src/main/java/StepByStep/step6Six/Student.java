/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

/**
 *
 * @author MartyMcAir
 */
public class Student implements Cloneable {

    private int id = 71;
    private String name;
    private int age;

    int getId() {
        return this.id;
    }

    void setId(int id) {
        this.id = id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
