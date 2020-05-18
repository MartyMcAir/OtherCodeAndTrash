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
public class zzzAbsRun {
    public static void main(String[]args){
        // Восходящее приведение типа подкласса zzzAbsCat
        // к его супер класссу zzzAbsAnimal
        
        // Полиморфизм переменных: объявленной переменной базового супер класса
        // присваиваются экземпляры классов наследовавших его
        // т.е. эта перменная содержит может содержать ссылки на объекты
        // производных классов
        zzzAbsAnimal m = new zzzAbsCat("мяу шшш", "царап царап");
        zzzAbsAnimal m2 = new zzzAbsDog("гав ррр", "кусак жевак");
        m.dois();
        m.soundis();
        m2.dois();
        m2.soundis();
        
        zzzAbsCat cat = new zzzAbsCat();
        cat.additional(); // метод не доступный через переменную супер класса
        // Нисходящее приведение супер класса к его подклассу _ выдает ошибку часто;
//        ((zzzAbsKitten)cat).additionKitten(); // метод доступен только в zzzAbsKitten
        
        zzzAbsKitten kitty = new zzzAbsKitten("", "");
        kitty.additionKitten();
    }
}
