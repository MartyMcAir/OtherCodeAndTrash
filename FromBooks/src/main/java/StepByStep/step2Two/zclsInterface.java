/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step2Two;

/**
 *
 * @author MartyMcAir
 */
public interface zclsInterface extends zclsInterfSuper {

    // при наследовании интерфейса другим интерфейсом их требования 
    // к классу реализовавшему их плюсуются 
    void overloadMethod();

    void overloadMethod(String var, int num);

    void mathMethod(int a, int b);

    // Дейолтные методы интерфейса их может быть произвольное кол-во
    default void defMethod() {
        System.out.println("Дефолтный перегружаемый метод");
    }

    default void defMethod(String str) {
        System.out.println("получена строка: " + str);
    }

    default void defMethod2() {
        System.out.println("Второй Дефолтный метод");
    }

    default void defMethod3() {
        System.out.println("Третий Дефолтный метод");
    }

}
