/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntrfGeneric_my;

/**
 *
 * @author MartyMcAir
 * @param <T>
 * @param <interf2>
 */
public class clsGeneric<T extends interf1 & interf2> {

    public static void main(String[] args) {
        // создаем экземпляр обобщенного класса
        // и отправляем в его конструктор объект А класса
        // Который реализует интерфейсы
        clsGeneric<clsImpl> var = new clsGeneric<>(new clsImpl());
        var.test();
    }

    public T var;

    public clsGeneric(T var) {
        this.var = var;
    }

    public void test() {
        this.var.test1();
        this.var.test2();
    }
}
