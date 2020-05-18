/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.Collections;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author MartyMcAir
 */
public class clsArr {

    public static void main(String args[]) {
        int[] arr = {3, 9, 6, 13, 8};
        System.out.println("Arrays.toString(arr): " + Arrays.toString(arr));

        clsArr cls = new clsArr();

        System.out.println("cls.getMin(arr): " + cls.getMin(arr));
        System.out.println("cls.getMax(arr): " + cls.getMax(arr));

        cls.reverseArr(arr);
        System.out.println("cls.reverseArr(arr): " + Arrays.toString(arr));

        cls.shuffle2(arr);
        System.out.println("cls.shuffle2(arr): " + Arrays.toString(arr));
        
        cls.fillRandom(arr, 99);
        System.out.println("cls.fillRandom(arr, 99): " + Arrays.toString(arr));
    }

    public void fillRandom(int[] arr, int to){
        Random r = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i]=r.nextInt(to);
        }
    }
    
    public void reverseArr(int[] arr) {
        int tmp = 0;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    // метод перемешивания элементов массива случайным образом
    public void shuffle2(int[] arr) {
        Random r = new Random();
        int tmp = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            j = (int) (r.nextInt(arr.length));
            // пропуск если совпадение случайного с текущим i элементом
            if (i == j) {
                continue;
            }
            // собственно сама манипуляция смешивания
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    // метод перемешивания элементов массива случайным образом
    public void shuffle(int[] arr) {
        int tmp = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            j = (int) (Math.random() * arr.length);
            // пропуск если совпадение случайного с текущим i элементом
            if (i == j) {
                continue;
            }
            // собственно сама манипуляция смешивания
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public int getMin(int[] arr) {
        int x = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (x > arr[i]) {
                x = arr[i];
            }
        }
        return x;
    }

    public int getMax(int[] arr) {
        int x = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (x < arr[i]) {
                x = arr[i];
            }
        }
        return x;
    }
}
