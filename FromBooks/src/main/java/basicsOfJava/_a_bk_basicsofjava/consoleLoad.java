/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

/**
 *
 * @author MartyMcAir
 */
public class consoleLoad {

    public static void main(String[] args) throws InterruptedException {
        System.out.print("...0%");
        for (int i = 5; i < 101; i += 5) {
            Thread.sleep(1000);
            System.out.println("\r... " + i + "%");
        }
        System.out.println();
        System.out.println("Hello");
    }
}
