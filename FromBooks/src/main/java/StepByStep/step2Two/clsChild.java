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
public class clsChild extends cls3Tree {
    
    clsChild(){ }
    clsChild(String forOverLoad1){
        // вызываем поля е методы суперКласса через ключ слово super
        super(forOverLoad1);
        super.forOverLoad1=forOverLoad1;
        super.overLoadMethod(forOverLoad1, forOverLoad2);
    }
    clsChild(String zzz, String test){
        this(zzz); // конструктор сам себя вызывает _ Рекурсия
        System.out.println("\nконструктор вызвал сам себя: "+test);
    }
    // Наследуется все (в том числе перечисления) кроме приватных членов класса
    public static void main(String[] args) {
        // переменная доступна без создания т.е. наследуется из класса cls3Tree
        staticStr = "публичная статичная строка";
        staticMethod();
        enumColor var1 = enumColor.pink;
        
        clsChild cls = new clsChild();
        cls.setPrivate("\nрезультат работы get и set методов супер класса, \n"
                + "запушено из class clsChild extends cls3Tree ");
        System.out.println(cls.getPrivate());
        
        // свой странный порядок выполнения
        clsChild cls2 = new clsChild("\n\nover loaaad", "cls2 запущен");
        cls2.setPrivate("testttt");
        cls2.overLoadMethod(staticStr, staticStr);
    }

    void showExtendsVaiables() {
        // переменные доступны без создания т.е. наследуются из класса cls3Tree
        String publStr = publicStr;
        String protStr = protectedStr;
        String publCons = PUBL_CONSTANT;
        String strOver1 = forOverLoad1;
        String strOver2 = forOverLoad2;
        int strOver3 = forOverLoad3;
    }

    void showExtendsMethods() {
        // наследуеммые методы из класса cls3Tree
        this.overLoadMethod();
        this.overLoadMethod(forOverLoad1, forOverLoad2);
        this.overLoadMethod(forOverLoad1, forOverLoad2, forOverLoad3);

        this.protectedMethod();
        this.publicMethod();

        this.setPrivate(protectedStr);
        this.getPrivate();
        this.finalMethod();
    }

    @Override
    void publicMethod() {
        System.out.println("метод publicMethod(), "
                + "переопределен в классе clsChild");
    }

}
