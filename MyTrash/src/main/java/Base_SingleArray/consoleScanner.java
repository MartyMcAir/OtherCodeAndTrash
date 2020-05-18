/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_SingleArray;

import java.util.Scanner;

/**
 *
 * @author MartyMcAir
 */
public class consoleScanner {

    public static void scan(){
        Scanner sc = new Scanner(System.in);
        String name, surname;
        int number;
        System.out.print("Введите имя: ");
        name = sc.nextLine();
        System.out.println("Введите фамилию: ");
        surname = sc.nextLine();
        System.out.println("Введите фифру: ");
        number = sc.nextInt();
        System.out.println("Результаты: "+name+" "+surname+" "+number);
    }
    
    public static void main(String[] args) {
        consoleScanner.scan();
    }
}
