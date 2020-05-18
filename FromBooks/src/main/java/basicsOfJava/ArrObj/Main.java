/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.ArrObj;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
        //Объявляем массив объектов А класса состоящий из 3х элементов
        A[] aArr = new A[2];

        // Присваиваем элементам массива значения
        aArr[0] = new A();
        aArr[1] = new A();
//        aArr[2]= new A();

        // Динамически т.е. сразу при объявлении присваиваем элементам массива значения
        A[] aArr2 = {new A(), new A(), new A()};

        // Обращаемся к полям элементовы массива т.е. 
        // через отдельные его элементы к полям отдельных объектов
        aArr[0].x = 10;
        aArr[0].s = "Строка";
        aArr[1].x = 20;
        aArr[1].s = "Строка2";

        // Перебираем элементы объектного массива
        for (A obj : aArr) {
            System.out.println(obj.x);
            System.out.println(obj.s);
        }

        System.out.println();
        // Массив объектов A класса и классы наследуемые его
        // И A() с перегруженным конструктором
        A[] aArr3 = {new A(), new A("тест1"), new Child1(), new Child2("тест2")};
        System.out.println( aArr3[1].s );   // тест1 
        System.out.println( aArr3[3].s );   // тест2
        
        aArr3[1].showAny();   // метод А класса
        
        Child1 chld1 = new Child1();
        chld1.show();   // класс Child1
// метод show() из класса Child1 доступен только при приведении к его типу класса
        ( (Child1) aArr3[2]).show();    // класс Child1

    }
}
