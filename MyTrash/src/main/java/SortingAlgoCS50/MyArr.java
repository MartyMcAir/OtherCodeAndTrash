package SortingAlgoCS50;

import java.util.Arrays;

public class MyArr {
    public static void main(String[] args) {
        printArr(getReverseArrIntegers(100));
    }

    public static Integer[] getArrIntegers(int amount) {
        Integer[] arr = new Integer[amount];

        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        return arr;
    }

    //  найхудший вариант для сортировки _ это массив в обратном порядке
    public static Integer[] getReverseArrIntegers(int amount) {
        Integer[] arr = new Integer[amount];

        for (int i = 0, length = amount - 1; i < amount; i++, length--)
            arr[i] = length;
        return arr;
    }

    public static <T> void arrayShuffle(T[] arr) {
        T tmp;
        for (int i = 0; i < arr.length; i++) {
            int rnd = (int) (Math.random() * arr.length);
            tmp = arr[i];
            arr[i] = arr[rnd];
            arr[rnd] = tmp;
        }
    }

    public static <T> void printArr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String s = (i % 10 == 0) ? ", \n" : ", ";
            System.out.print(arr[i] + s);
        }
    }

    public static <T> void printArr2(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static <T> void printArr3(T[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }
}
