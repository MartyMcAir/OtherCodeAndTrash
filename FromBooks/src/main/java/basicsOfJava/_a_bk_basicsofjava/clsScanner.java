/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.util.Scanner;

/**
 *
 * @author MartyMcAir
 */
public class clsScanner {
    public static void main(String[] args){
        int x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ввведите четное число большее 4х!: ");
        x=sc.nextInt();
        if(x>4){
            if(x%2==0){
                System.out.println("Вы ввели четное число больше 4х: "+x);
            } else {
                System.out.println("Вы ввли нечетно число большее 4х: "+x);
            }
        } else {
            System.out.println("Вы ввели число меньшее или равное 4м!: "+x);
        }
    }

}
