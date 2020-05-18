/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon1;

import java.io.*;

/**
 *
 * @author MartyMcAir
 */
public class clsRun {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Cat vaska = new Cat("Vaska", "Gray", 4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        //сохраняем состояние кота Васьки в поток и закрываем его(поток)
        ous.writeObject(vaska);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        //создаём кота для опытов и инициализируем его состояние Васькиным
        Cat cloneVaska = (Cat) ois.readObject();
        System.out.println(vaska);
        System.out.println(cloneVaska);
        System.out.println("*********************************************");
        cloneVaska.setColor("Black");
        //Убеждаемся что у кота Васьки теперь есть клон, над которым можно ставить опыты без ущерба Василию
        System.out.println(vaska);
        System.out.println(cloneVaska);
    }

    void showConstructorClone() {
        // клонирование с использование конструктора
        Person2 original = new Person2(18, "Grishka");
        Person2 clone = new Person2(original);
        System.out.println(original);
        System.out.println(clone);
    }

    void showSimpleClone() throws CloneNotSupportedException {
        // Поверхностное клонирование
        Car car = new Car("Green");
        Person person = new Person(car, 25, "Mike");

        Person clone = (Person) person.clone();
        System.out.println(person);
        System.out.println(clone);
        clone.name = new String("Ivan");
        clone.car.color = "red";
        System.out.println(person);
        System.out.println(clone);
    }
}
