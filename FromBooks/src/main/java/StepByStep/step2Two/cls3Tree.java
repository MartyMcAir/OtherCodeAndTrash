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
public class cls3Tree {
    // Весь раздел ~4-6h
    
    
    // поля и методы являются (если неказано), то по умолчанию с 
    // тем модификатором доступа, который и у класса в котором они находятся
    String publicStr = "публичная строка";
    static String staticStr = "публичная статичная строка";
    // private доступен только Супер Классу и его наследникам !?
    // инкапсуляция защита данных _ доступ только через класс в котором находятся
    // или только через get и set методы
    private String privateStr = "приват строка";
    protected String protectedStr = "протектед строка";

    final String PUBL_CONSTANT = "публичная константа нельзя изменить";

    String forOverLoad1;
    String forOverLoad2;
    int forOverLoad3;

    // Перегружаемые конструкторы класса, запустится соответствующий типу и
    // количеству аргументов на взодящих данных
    cls3Tree() {
    }

    cls3Tree(String forOverLoad1) {
        // через слово this получаем доступ к полям и методам текущего класса
        // присваиваем значение полю класса
        this.forOverLoad1 = forOverLoad1;
        // так же через this вызываем перегружаемый метод
        this.overLoadMethod();
    }

    cls3Tree(String forOverLoad1, String forOverLoad2) {
        this.forOverLoad1 = forOverLoad1;
        this.forOverLoad2 = forOverLoad2;
        this.overLoadMethod(this.forOverLoad1, this.forOverLoad2);
    }

    cls3Tree(String forOverLoad1, String forOverLoad2, int forOverLoad3) {
        this.forOverLoad1 = forOverLoad1;
        this.forOverLoad2 = forOverLoad2;
        this.forOverLoad3 = forOverLoad3;
        this.overLoadMethod(forOverLoad1, forOverLoad2, forOverLoad3);
    }

    enum enumColor {
        pink, green, blue
    };

    public static void main(String[] args) {
        {
            System.out.println("Анономный метод, ,без имени");
        }
        enumColor var1 = enumColor.pink;
        cls3Tree treeAnonim = new cls3Tree(){
            // final и static методы не могут быть переопределены
            @Override // так же назвают полиморфизм времени выполнения
            void overLoadMethod(){
                System.out.println("overLoadMethod переопределен анонимным"
                        + "вложенным классом");
            }
        };
        treeAnonim.overLoadMethod();

        // Статические способы получения из класса
        String strGetStatic = cls3Tree.staticStr;
        cls3Tree.staticMethod();
        
        // Способы получения из класса по средством конструктора класса
        // т.е. создание объекта класса
        cls3Tree tree = new cls3Tree();
        String strGetPublic = tree.publicStr;
        String strGetPrivate = tree.privateStr;
        String strGetProtected = tree.protectedStr;
        String strGetConstatnt = tree.PUBL_CONSTANT;

        System.out.println("\nВызываем методы через экземпляр класса: ");
        tree.privateMethod();
        tree.protectedMethod();
        tree.publicMethod();
        tree.finalMethod();
        
        System.out.println("\nИспользуем перегружаемые конструкторы: ");
        cls3Tree tree1 = new cls3Tree("перегрузка №1");
        cls3Tree tree2 = new cls3Tree("перегрузка №2", "перегрузка и опять №2");
        cls3Tree tree3 = new cls3Tree("перегрузка №3",
                "перегрузка и опять №3", 333);

        System.out.println("\nИспользуем перегружаемые методы: ");
        // через конструктор которому отправляли значения
        // на выходе значение не null
        tree1.overLoadMethod();  //  а здесь значение null 
        // разные объекты экземпляры класса с разными сигнатурами и свойствами объекта

        tree.overLoadMethod();
        tree.overLoadMethod("перегружаемый метод №2", "#2");
        tree.overLoadMethod("перегружаемый метод №3", "#3", 666);
        
        System.out.println("\nМетод принимает только тот тип данных, которые"
                + " наследуют супер класс Number");
        methodShowInteger(999);
        methodShowInteger(33.66);
        methodShowInteger(33.66F);
    }
 
    public static void methodShowInteger(Number str) {
        System.out.println(str.toString());
    }

    // присваивание значения приватной переменной и её получение
    // через так называемые методы get'еры и set'еры
    public void setPrivate(String privateStr) {
        this.privateStr = privateStr;
    }

    public String getPrivate() {
        return privateStr;
    }

    final void finalMethod() {
        System.out.println("finalMethod: " + PUBL_CONSTANT);
    }
    
    void publicMethod() {
//        staticMethod();
//        forRunFromAnonim();
//        privateMethod();
//        protectedMethod();
        System.out.println("publicMethod: " + publicStr + ", " + staticStr
                + ", " + privateStr + ", " + protectedStr);
    }

    // статический метод для него доступны только статические члены класса
    static void staticMethod() {
//        forRunFromAnonim();
        System.out.println("staticMethod: " + staticStr);
    }

    // private доступен только Супер Классу и его наследникам !?
    // инкапсуляция защита данных _ доступ только через класс в котором находятся
    // или только через get и set методы
    private void privateMethod() {
        System.out.println("publicMethod: " + publicStr + ", " + staticStr
                + ", " + privateStr + ", " + protectedStr);
    }

    protected void protectedMethod() {
        System.out.println("publicMethod: " + publicStr + ", " + staticStr
                + ", " + privateStr + ", " + protectedStr);
    }

    // перегружаемые методы одно и тоже имя но в зависиммости от входящих
    // данных в кач. аргумента зависит, то какой именно метод запустится
    void overLoadMethod() {
        if (forOverLoad1 == null) {
            System.out.println("overLoadMethod 1:  forOverLoad1==null"
                    + "\t\t-экземпляру класса не отправляли данные об этой перменной");
        } else {
            System.out.println("overLoadMethod 1: " + forOverLoad1);
        }
    }

    void overLoadMethod(String forOverLoad1, String forOverLoad2) {
        // если использовать this,то при вызове только метода будет null или 0
        // а если через конструктор будет верное значени
//        System.out.println("overLoadMethod 2: "+this.forOverLoad1+", "+
//                this.forOverLoad2); 
        System.out.println("overLoadMethod 2: " + forOverLoad1 + ", "
                + forOverLoad2);
    }

    void overLoadMethod(String forOverLoad1, String forOverLoad2,
            int forOverLoad3) {
        System.out.println("overLoadMethod 3: " + forOverLoad1 + ", "
                + forOverLoad2 + ", " + forOverLoad3);
    }

}
