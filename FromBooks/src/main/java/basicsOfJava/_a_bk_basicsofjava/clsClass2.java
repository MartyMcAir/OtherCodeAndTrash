/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author MartyMcAir
 */
public class clsClass2 {

    public static void main(String[] args) {
        int x = 10;
        System.out.println(sum(3, 5));
        print("LoadRunner write");
        printOk();

        LocalDate ld = LocalDate.now();
        clsClass1.print(ld.toString());
        print(sum(3.13, 6.8) + " ");
        print(x + "");
        print(sum(10.13, 10.10, 10.3) + "");

        withYearLocale(ld, 2033);
        print(ld.toString());

        GregorianCalendar d = new GregorianCalendar();
        System.out.printf("%tc\n", d);
        setYear(d, 2333);
        System.out.printf("%tc\n", d);
        setYear((GregorianCalendar) d.clone(), 2888);
        System.out.printf("%tc\n", d);

        int arrInt[] = {3, 6, 8, 9, 13};
        print(Arrays.toString(arrInt));
        arrSet(arrInt);
        print(Arrays.toString(arrInt));

        arrSet2(new int[]{1, 2, 3}, "; ");  // 1; 2; 3;

        String resArr = printFromBook(new int[]{6, 5, 4}, "; ");
        print(resArr);  // 6; 5; 4
        
        int[] arr2 = {1, 2, 3, 10};
        // получаем новыйй массив с удвоенными значениями
        print( Arrays.toString( get2Arr(arr2) ) ); 
    }

    public static int[] get2Arr(int[] arr){
        int[] arr_new = new int[arr.length];
        for(int i=0; i<arr.length;i++){
            arr_new[i]=arr[i]*2; 
        }
        return arr_new;
    }
    
    public static String printFromBook(int[] a, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(String.valueOf(a[i]));
            if (i != a.length - 1) {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static void arrSet2(int[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + str);
        }
        System.out.println();
    }

    public static void arrSet(int[] arr) {
        arr[1] = 18;
    }

    public static void setYear(GregorianCalendar var, int year) {
        var.set(year, Calendar.MAY, 23);
    }

    public static void withYearLocale(LocalDate var, int year) {
        var.plusYears(year);
    }

    public static double sum(double x, double y, double c) {
        return x + y + c;
    }

    public static int sum(int x, int y) {
        return x + y;
    }

    public static double sum(double x, double y) {
        return x + y;
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printOk() {
        System.out.println("Ok");
    }
}
