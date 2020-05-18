/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step3Tree;

/**
 *
 * @author MartyMcAir
 */
public class zclsRunFinMain implements Finterf, FinParam {

    public static void main(String[] args) {
        // Функциональные интерфейсы и их использование с лямбда выражениями
        System.out.println("Finterf cls = new cls4Four(): ");
        Finterf cls = new zclsRunFinMain();
//        cls.calc(3, 8); // методу calc собственно самому функциональному методу
// т.е. вместо его и присваивается из лямбда выражений схема по которой 
// необходимо обработать данные
        cls.defshowRes(8, 10);   // + _ 18
        cls.defshowRes(3);   // a+3 _ 6
        cls.defshowRes(4, 4, 2);   // a+b / c _ 4

        // При использовании лямбда выражений автоматич создается анонимный
        // экземпляр класса 
        System.out.println("\n(a, b) -> (a * b): ");
        Finterf mult = (a, b) -> (a * b);
        mult.defshowRes(6, 6);   // 36

        System.out.println("(a, b) -> (a / b): ");
        Finterf div = (a, b) -> (a / b);
        div.defshowRes(10, 2);   // 5 

        System.out.println("(a, b) -> {return (a * b): ");
        Finterf ret = (a, b) -> {
            return (a * b);
        };
        ret.defshowRes(3, 3);   // 9

        // присваиваем интерфейсной перменной метод через объектную ссылку 
        // при этом метод должен быть не статичным и присваивание может быть
        // только если сигнатуры совпадают и это функционал интерфейс
        System.out.println("\nМетод через объектную перменную "
                + "Finterf mult2 = cls2::divisionM: ");
        zclsRunFinMain cls2 = new zclsRunFinMain();
        Finterf div2 = cls2::divisionM;
        Finterf mult2 = cls2::multipleM;
        div2.defshowRes(10, 2);
        mult2.defshowRes(3, 3);

        // используем лямбда выражения в качестве праметра
        //  т.е. по сути это метод возвращаемый boolean значение
        System.out.println("\nЛямбда в качестве параметра "
                + "(n) -> ((n % 2) == 0): ");
        FinParam fip = (n) -> ((n % 2) == 0);
        System.out.println("isBl(9): " + fip.isBl(9));
        int[] arr = {3, 6, 8, 9, 13, 18, 20};
        fip.showEvenOdd(arr);
    }

    int multipleM(int a, int b) {
        return (a * b);
    }

    int divisionM(int a, int b) {
        return (a / b);
    }

    // Finterf
    @Override
    public double calc(int a, int b) {
        return (a + b);
    }

    // FinParam
    @Override
    public boolean isBl(int n) {
        return (n % 2) == 0;
    }
}
