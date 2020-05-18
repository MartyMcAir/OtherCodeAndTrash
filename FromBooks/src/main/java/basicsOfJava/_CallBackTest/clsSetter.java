/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._CallBackTest;

/**
 *
 * @author MartyMcAir
 */
public class clsSetter {

    intrfDo itd;

    // сеттим связываем присваиваем значения полученные от интерф перменн
    clsSetter(intrfDo itd) {  // регистрируем обработчик
        this.itd = itd;
    }
    
    public void callback() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            itd.showMessage();
            Thread.sleep(1000);
        }
    }
}
