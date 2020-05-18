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
public class cls4Four {

    public static void main(String[] args) {
        // Обобщенные классы Дженерики
        System.out.println("Использование обобщенного класса,"
                + " для типа данных Integer: ");
        clsGen<Integer, Integer> gen = new clsGen<>();
        gen.setK(999);
        gen.setT(333);
        System.out.println("gen.getK(): " + gen.getK());
        System.out.println("gen.getT(): " + gen.getT());

        System.out.println("\nИспользование обобщенного класса,"
                + " ограничиваем типом Number (доступны все типы, \nклассы "
                + "наследовавшие Number т.е. Integer, Double..):");
        clsGen<Number, String> gen3 = new clsGen<>();
        gen3.setT(23412421L);
        System.out.println("long gen3.getT(): " + gen3.getT());
        gen3.setK("Строка");
        System.out.println("разные тиы данных, второй тип данных строка"
                + " gen3.getK() \n(хотя и на уровне класса clsGen"
                + " ограничено типом данныз Number): "+ gen3.getK());
        
        System.out.println("\nИспользование обобщенного класса,"
                + " для произвольных данных");
        clsGen<Object, Object> gen2 = new clsGen<>();
        gen2.setT("Текст");
        System.out.println("текст gen2.getT(): " + gen2.getT());
        gen2.setT(666);
        System.out.println("цифра gen2.getT(): " + gen2.getT());
        gen2.setT(666.888F);
        System.out.println("float gen2.getT(): " + gen2.getT());
        
        System.out.println("\nИспользование обобщенного класса,"
                + " extends за счет интерфейсов и отправка в его конструктор"
                + ", \nкласса наследующего данные интерфейсы: ");
        clsGenExt<clsImplForGen> gen4 = new clsGenExt(new clsImplForGen());
        gen4.runInterfMethods();
        
        System.out.println("\nОбобщенные методы");
        cls4Four cls = new cls4Four();
        cls.showGen("тест на", 999);
        System.out.println("не обобщенный Метод ограниченный типом данных Number:"+
                cls.showNumber(999.333F));
        
        System.out.println("\nДругие обобщенные методы: ");
        clsGenLite gLite = new clsGenLite();
        cls.show(gLite);
        // ? - не работае как произвольный тип почему!?
        cls.showTwo(gLite);
        
        System.out.println("\nНаследование обобщенных классов (Полиморфизм): ");
        clsGen2 clsG2 = new clsGen2("text1", "text2");
        clsG2.showGen1();
        clsG2.showGen2();
        
        System.out.println("\nНаслед обобщенные классы с работающими ограничениями: ");
        clsGen2<String, Number> clsG3 = new clsGen2<String, Number>("text1", 66.33);
        clsG3.showGen2();
        
        System.out.println();
        genFinImpl gfin = new genFinImpl();
        gfin.showT("строка из класса реализущего обобщенный функциональный интерфейс");
    } 

    void showTwo(clsGenLite<? extends Number> obj){
        System.out.println("Обобщенный метод в рамках обобщенного clsGenLite класса "
                + "\nпри этом ипользуется маска типа ?: "
        );        
    }
    
    <T> void show(clsGenLite<T> obj){
        System.out.println("Обобщенный метод в рамках обобщенного clsGenLite класса: "
        +obj.getClass().getName());        
    }
    
    <T, K> void showGen(T objT, K objK) {
        System.out.println("метод произвольных данных T: "+objT+", K: "+objK);
    }

    Number showNumber(Number obj) {
        return obj;
    }
    
}
