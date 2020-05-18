/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.INTRF_ReadWrite;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
        // Присваиваем интерфейсным переменным экземпляры классов
        // реализующих их
        iRead r1 = new A(); // содержит строку 1 _ и реализует iRead
        // _ её получает методом read() вызовом внутри конструктора D класса
        // Метод read() берут из А класса
        iWrite w = new C();

        // В D классе отправляем для связки
        D obj1 = new D(r1, w);

        obj1.change();   // change метод реализуется внутри D класса _ toUpperCase()

        // print() метод внутри D класса вызывает write метод из класса
        // связанного в конструкторе D класса т.е. это C класс
        // и он просто выводит строку в консоль
        obj1.print();   // СТРОКА 1

        // B класс реализует iRead, но мы создаем просто его экземпляр
        // Для отправки в конструктор D класса
        B r2 = new B(); // содержит строку 2 
        // _ её получает методом read() вызовом внутри конструктора D класса
        // Метод read() берут из B класса

        // w - использует метод write c C класса
        D obj2 = new D(r2, w);
        obj2.change(); // change метод реализуется внутри D класса _ toUpperCase()

        // print() метод внутри D класса вызывает write метод из класса
        // связанного в конструкторе D класса т.е. это C класс
        // и он просто выводит строку в консоль
        obj2.print();   // СТРОКА 2

        r2.print(); // СТРОКА 2 можно получить и так

        // Пример использования одного класса реализующего оба интерфейса
        E var1 = new E();
        D obj3 = new D(var1, var1);
        obj3.change();
        obj3.print(); // СТРОКА 3 Работает

        // Пример использования одного G класса реализующего
        // один интерфейс iReadWrite который extends iRead, iWrite
        G var2 = new G();
        D obj4 = new D(var2, var2);
        obj4.change();
        obj4.print();   // СТРОКА 4 ...
        // моя константа
       
        System.out.println();
        // Пример доступа к статическому методу интерфейса
        iReadWrite.showStat();   // напрямую
        var2.runStatFromIntrf();  // через экземпляр класса реализовавшего его
        
        System.out.println();
        // Пример вызова метода интерфейса по умолчанию 
        // и его переопределенную версию
        // через экземпляр класса реализовавшего его без переопределений
        var2.showDef();  
        // через экземпляр класса реализовавшего и переопределившего его метод
        Mimpl impl = new Mimpl();
        impl.showDef();   // переопределен
        
    }
}
