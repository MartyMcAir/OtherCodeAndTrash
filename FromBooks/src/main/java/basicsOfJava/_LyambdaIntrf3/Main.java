/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._LyambdaIntrf3;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
        clsReg cls = new clsReg();
        cls.regSet(new intrfWith2arg()
        { // Используем анонимный класс
            @Override
            public void showCalc(int a, int b){
            System.out.println("анонимный класс: "+a+"+"+b+"="+(a+b));
            }
        });
        cls.callback(3, 2);  //анонимный класс a+b=5
        
        cls.regSet((a, b)->System.out.println("лямбда-выражение: "+a+"-"+b+"="+(a-b)));
        cls.callback(15, 5);  // лямбда-выражение: a-b=10
        
        // Интерфейсной переменной можно присвоить ссылку на любой метод
        // Важно лишь совпадение сигнатур
        clsMethods mth = new clsMethods();
        intrfWith2arg intf = mth::division;
        cls.regSet(intf);
        cls.callback(10, 3);  // division: 10/3=3
        
        // Отправляем ссылки на наш метод 
        // важно лишь совпадение (сигнатур т.е.) типов и кол-во аргументов
        cls.regSet( mth::multiply );
        cls.callback(10, 3);   // mutiply: 10*3=30
        
        cls.regSet( mth::multiplyAndDivis );
        cls.callback(10, 3);   // multiplyAndDivis: (10*3)/3=10
    }
}
