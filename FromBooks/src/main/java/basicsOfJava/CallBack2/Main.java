/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.CallBack2;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) {
        MyButton btn = new MyButton();
        IClick ic = new A();
        //btn.reg(ic); // регистрируем обработчик _ set Обработчик
        
        // регистрируем обработчик через вложенный анонимный класс
        // в нем же и переопределяем метод интерфейса
        btn.reg(new IClick(){  // анонимный класс
            @Override
            public void onClick(){
                System.out.println("Имитация кнопки из анонимного класса");
            }
        }); 
        
        for (int i = 0; i < 5; i++) {
            btn.click();   // генерируем нажатие
            try {
                Thread.sleep(1000); // имитация нажатия, ждать 1сек
            } catch (InterruptedException e) { // обработчик исключений
                e.printStackTrace();
                System.exit(1); // выйти из программы
            }
        }
    }
}
