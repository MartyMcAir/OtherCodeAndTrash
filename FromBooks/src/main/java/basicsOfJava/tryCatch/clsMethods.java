/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.tryCatch;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author MartyMcAir
 */
public class clsMethods {

    public void showlog(){
        // при необходимости отключение протокола
        // Logger.getLogger("myLoG").setLevel(Level.OFF);
        try{
            Logger myLoG = Logger.getLogger("myLoG");
            FileHandler fh = new FileHandler("C:\\z_n\\myLoG.txt");
            
            // Сокращенный формат
            fh.setFormatter(new SimpleFormatter());
            myLoG.addHandler(fh);
            myLoG.setUseParentHandlers(false);
        } catch(Exception e){
            e.printStackTrace();
        }
        int[][] arr = {{1,2,3,4}, {9,8,7,6}};
        int i, j;
        for(i=0; i<arr.length; i++){
            for(j=0;j<arr[i].length; j++){
                // Показываем массив
                System.out.printf("%3s", arr[i][j]);
                // Производим запись в Лог файл
                Logger.getLogger(
                        "myLoG").log(Level.INFO, "i= "+i+"; j= "+j);
            }
            System.out.println();
        }
    }
    
    // Пример воженности catch блоков и перехвата исключения 
    // от внутреннего блока catch к внешнему
    public void showThrow(){
        int x=0, y=10;
        try{
            try{
                y=y/x;
            } catch(ArithmeticException e){
                // генерация  _ вброс исключения
                throw new ArithmeticException("нельзя делить на 0");
            }
            System.out.println("Инструкция после вложенного обработчика.");
        } catch(ArithmeticException e){
            // Перехватываем повторное исключение из внутреннего блока catch
            System.out.println(e.getMessage());
            y=0;
        }
        System.out.println("y= "+y);
    }
    
    public void showScannerVariable2() {
        int x = 0, result = 0, count = 0;
        String str = " ";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("ваша цифра или введите stop для результата: ");
            str = sc.nextLine();
            if (str.equals("stop")) {
                break;
            }

            try {
                x = Integer.parseInt(str);
                result += x;
            } catch (NumberFormatException e) {
                count++;
                System.out.println("Необходимо ввести целое число."
                        + "У вас осталось попыток: " + (3 - count));
            }
        }
        System.out.println("Сумма ваших чисел: " + result);
    }

    public void showScannerVariable() {
        int x = 0, result = 0, count = 0;
        String s = " ";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(
                    "введите число, или stop для получения результата: ");
            s = sc.nextLine();
            if (s.equals("stop")) {
                break;
            }

            try {
                x = Integer.parseInt(s);
                //if(x==0) break;
                result += x;
                // count = 0 ;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число!"
                        + " У вас осталось попыток: " + (3 - count));
                if (count == 3) {
                    break;
                }
                count++;
            }
        }
        System.out.println("Сумма введенных вами чисел: " + result);
    }

    public void showScanner() {
        int userData;
        System.out.print("Введите цифру на которую поделить 333: ");
        Scanner sc = new Scanner(System.in);

        try {
            userData = sc.nextInt();
            System.out.println("(333/userData): " + (333 / userData));
        } //        catch(NullPointerException e){
        //            System.out.println("userData!: ") ;
        //            System.out.println("e.getMessage(): "+e.getMessage() ) ;
        //            System.out.println("e.getClass().getName(): "+e.getClass().getName() ) ;
        //        } catch(Exception e){
        //            System.out.println("userData!: ") ;
        //            System.out.println("e.getMessage(): "+e.getMessage() ) ;
        //            System.out.println("e.getClass().getName(): "+e.getClass().getName() ) ;
        //        }
        finally {
            System.out.println("Программа завершена.");
        }
    }
}
