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
public class clsAccess {
    public static void main(String[] args) {
        {
            System.out.println("Анономный метод, ,без имени");
        }

        // Статические способы получения из класса
        String strGetStatic = cls3Tree.staticStr;
        cls3Tree.staticMethod();

        // Способы получения из класса по средством конструктора класса
        // т.е. создание объекта класса
        cls3Tree tree = new cls3Tree();
        String strGetPublic = tree.publicStr;
        // приватные не доступны
//        String strGetPrivate = tree.privateStr;
        String strGetProtected = tree.protectedStr;
        String strGetConstatnt = tree.PUBL_CONSTANT;

        System.out.println("\nВызываем методы через экземпляр класса: ");
        // приватные не доступны
//        tree.privateMethod();
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
        
        System.out.println("\nИспользуем set и get методы для установки "
                + "значения приватной переменной и её получения: ");
        tree.setPrivate("значение приватной переменной");
        System.out.println("tree.getPrivate(): "+tree.getPrivate());
    }
}
