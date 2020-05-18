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
abstract public class zclsAbstract extends zclsAbsSuper {
    // при наследовании абстракта абстрактом их требования к класса исходному
    // что наследует абстракт наследовавший других _ требования плюсуются
    // словно все они в одном абстракте

    // Перегружаемые конструкторы абстрактного класса
    zclsAbstract(){}
    zclsAbstract(String mmm){
        m=mmm;
    }
    
    // перегружаемый метод absMethod();
    abstract void absMethod();

    abstract void absMethod(String str);

    abstract void absMethod(String str, int num);

    void showM() {
        System.out.println("обычный метод внутри абстрактного класса,"
                + "\n и установленное значение set и get методами: " + m);
    }
}
