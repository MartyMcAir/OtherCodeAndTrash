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
abstract public class zclsAbsSuper {
    String m;
    // нельзя создать экземпляр абстрактного класса
    // только наследование с 
    // переопределением или использованием его методов

    //Абстратные методы абстрактного класса
    // set и get методы
    abstract void setAbsM(String m);

    abstract String getAbsM();  
}
