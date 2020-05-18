/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author MartyMcAir
 */
public class zArr {
    public static void main(String[] args){
        int[] arr1= {1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[3];
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2)); 
        
        arr2= Arrays.copyOfRange(arr1, 4, 11); // правильное копирование массивов
        System.out.println(Arrays.toString(arr2)); // копия успешно создана
        
        int[] arr3=new int[8];
        System.arraycopy(arr1, 2, arr3, 1, 3); // правильное копирование массивов
        System.out.println(Arrays.toString(arr3) );
        
        int[] arr4 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(arr1, arr4));//сравнение массивов true
        
        
        int[] numb2=new int[10]; // массив из 10ти пустых элементов
        int[] numArr = {3, 6, 8, 9};
        String[] strArr = {"Java", "SQL", "XML", "Android"};
        char[] chrArr = {'a', 'b', 'c', 'd'};
        chrArr = new char[] {'d', 'c', 'b', 'a'}; // реинециализация
        // присваивание индексу
        numArr[0]=12;
        strArr[1]="Power";
        // Манипулирование элементами массива как перменными
        System.out.println("\nResult 12-6: "+ (numArr[0]-numArr[1]) );
        // безымянный анонимный массив в качестве аргумента
        showIntArr(new int[] {3, 8, 33, 999} );   // for(int i : arr){ }
        // Перебор элементов массива
        showStrArr(strArr);   // for
        showCharArrWhile(chrArr);   // while
        
        int[] arrForRnd = {1, 2, 3, 4, 5, 6, 7, 8};
        //shuffle(arrForRnd);   // перемешивание mix элементов массива
        myFillRandom(arrForRnd, 100);
        //System.out.println(Arrays.toString(arrForRnd) );
        
        byte[] arrByte = new byte[4];
        fillByteRnd(arrByte);
        System.out.println(Arrays.toString(arrByte));
        
    }
    
    // Заполнение массива случайными цифрами в пределах типа данных byte
    public static void fillByteRnd(byte[] arr){
        Random r = new Random();
        r.nextBytes(arr);
    }
    
    // наполнение массива случайными значениями в пределах need_num
    public static void myFillRandom(int[] arr, int need_num){
        Random rnd = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i]= rnd.nextInt(need_num);
        }
    }
    
    public static void shuffle(int[] arr){
        int tmp=0, j=0;
        for(int i=0; i<arr.length; i++){
            j=(int) (Math.random() *arr.length);
            if(i==j) continue;
            tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }
    }
    
    public static void myShuffle(int[] arr){
        Random rnd = new Random();
        int tmp, rnd_n;
        
        for(int i=0; i<arr.length; i++){
            // получаем рандомное число в диопазоне  arr.length
            rnd_n= rnd.nextInt( arr.length);
            
            // если текущий элемент массива совпадает 
            // с сгенерированным числом, то эту интерацию пропускаем
            if(arr[i]==rnd_n) continue;
            
            tmp=arr[i];   // присваиваем текущий элемент
            arr[i]=arr[rnd_n];   // текущему элементу случайный индекс
            arr[rnd_n]=tmp;  // случайному индексу текущий элемент
        }
    }
    
    public static void showIntArr(int[] arr){
        for(int i : arr){
            System.out.print(i+", ");
        }   System.out.println();
    }
    
    public static void showStrArr(String[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+", ");
        }   System.out.println();
    }
    
    public static void showCharArrWhile(char[] arr){
        int i=0;
        while(i<arr.length){
            System.out.print(arr[i]+", ");
            i++;
        }   System.out.println();
    }
}
