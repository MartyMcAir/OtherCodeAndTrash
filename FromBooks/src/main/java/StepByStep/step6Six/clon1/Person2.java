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
public class Person2 {
    private int age;
    private String name;
    public Person2(int age, String name) {
        this.age = age;
        this.name = name;
    }
    // конструктор копии
    public Person2(Person2 other) {
        this(other.getAge(), other.getName());
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person2{"
                + "age=" + age
                + ", name='" + name + '\''
                + '}';
    }
}
