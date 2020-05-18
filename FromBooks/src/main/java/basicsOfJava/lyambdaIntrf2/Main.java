/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.lyambdaIntrf2;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
        MyButton btn = new MyButton();
        A a = new A();
        btn.reg(a::printOnClick); // передаем ссылку на метод
        for(int i=0;i<3;i++){
            btn.click(); // генерируем нажатие
            try{
                Thread.sleep(1000);  // имитация ожидания 1сек
            } catch(InterruptedException e){
                e.printStackTrace();
                System.exit(1);
            }
        }
        
        clsImpl impl = new clsImpl();
        btn.reg(impl::onClick);
        btn.click();   // CallBack в работе

        btn.reg(impl::showOth);
        btn.click();  // Другой метод 

        btn.reg(a::showAny);
        btn.click();  // Другой метод из А класса
        
        MyButton btn2 = new MyButton( ()->System.out.println("Лямбда") );
        btn2.click();
        
        IClick ic2 = impl::showOth;
        btn2.reg(ic2);
        btn2.click(); // Другой метод 2
        
        // Используем ссылку на конструктор класса
        btn2.reg(bConstructor::new);
        btn2.click(); // Ссылка на конструктор класса работает
        
    }
}
