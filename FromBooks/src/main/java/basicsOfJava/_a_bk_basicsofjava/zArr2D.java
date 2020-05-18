/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author MartyMcAir
 */
public class zArr2D {

    public static void main(String[] args) {
        // массивы 2 строки 4 столбца но первый с 0 значениями
        int[][] arr = new int[2][4];
        int[][] arr2 = {{1, 2, 3, 4},
        {5, 6, 7, 8}};
        fillIntArr(arr);   // заполняем значениями 0вой массив
        //showIntArr2(arr);
        // [[1, 2, 3, 4], [5, 6, 7, 8]]
        //System.out.println(Arrays.deepToString(arr));

        // Зубчатый массив Gear Array
        int[][] arrTriangle = {{1},
        {2, 2},
        {3, 3, 3},
        {4, 4, 4, 4}};
        int[][] arrTri = new int[4][];
        arrTri[0] = new int[1];
        arrTri[1] = new int[2];
        arrTri[2] = new int[3];
        arrTri[3] = new int[4];
        fillIntArr(arrTri);
        //Arrays.fill(arrTri[0], 999); // наполняет по одному измерению массива
        //showIntArr2_1(arrTri);

        // Делает тоже самое и метод выше тока круче в одну строчку
        // [[1]
        // [2, 3]
        //System.out.println(Arrays.deepToString(arrTri).replace("], ", "]\n"));
        //System.out.println(Arrays.deepToString(arrTri));
        // 4D Array
        int[][][][] arr4D = new int[1][2][3][4];
        //simpleFillArr(arr4D);

        //System.out.println(Arrays.deepToString(arr4D));
        // Массив как таблица пользователей
        String[] arrUserTop = {"id", "name", "email", "passw"};
        String[] arrUserBottom1 = {"01", "Angela", "@angela", "AngelaPassw"};
        String[] arrUserBottom2 = {"02", "Mikasa", "@mikasa", "MikasaPassw"};
        String[] arrUserBottom3 = {"03", "Fisk", "@fisk", "FiskPassw"};
        String[][] arrUsers
                = {arrUserTop, arrUserBottom1, arrUserBottom2, arrUserBottom3};
        // id		name		email		passw
        // showStrArr1(arrUsers);

        // Матричный массив
        int[][] matrix = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 7, 12},
        {13, 14, 15, 16}};

        // print the elements of each row:
        int rowsLength = matrix.length;
        for (int row = 0; row < rowsLength; row++) {
            //showIntMatrix(rowsLength, row, matrix);
        }
        // вычисляем в массиве максимальное и минимальные значения
        showIntArr1_MinMax(matrix);
        showIntArrAndSearch_MinMax(matrix, 7);
    }

    //  1  2  3  4
    //  5  6  7  8
    public static void showIntArrAndSearch_MinMax(int[][] arr, int find) {
        int min_i = 0, min_j = 0, max_i = 0, max_j = 0;
        int min = arr[0][0], max = arr[0][0];
        ArrayList arrRes = new ArrayList();
        ArrayList f_i = new ArrayList();
        ArrayList f_j = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3s", arr[i][j]);
                if(find==arr[i][j]){
                    arrRes.add( arr[i][j] );
                    f_i.add(i);
                    f_j.add(j);
                }
                if (min > arr[i][j]) {
                    min = arr[i][j];
                    min_i = i;
                    min_j = j;
                }
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
            System.out.println();
        }
        System.out.println("min: " + min + " в строке №: " + (min_i + 1) + " в столбце №: " + (min_j + 1)
                + "\n max: " + max + " в строке №: " + (max_i + 1) + " в столбце №: " + (max_j + 1));
        
        System.out.println("Вы искали: "+find+" и найдено совпадений: "+arrRes.size());
        String q_i, q_j;
        for(int z=0; z<arrRes.size(); z++){
            // парсим в строку
            q_i = f_i.get(z).toString();
            q_j = f_j.get(z).toString();
            // при выводе номера строки и столбца парсим в цифру т.к. индекс
            // массивов с 0, а нумерация строк и столбцов считается с 1го
            System.out.println("в строке №: "+(Integer.parseInt(q_i)+1)+
                    " и в столбце №: "+(Integer.parseInt(q_j)+1) );
        }
    }
    
    // SKIP
    public static void simpleFillArr(int[][][][] arr4D) {
        //Arrays.fill(arrTri[0], 999);
//        int length1 = arr4D.length;
//        int length2 = arr4D[0].length;
//        int length3 = arr4D[0][0].length;
//        int length4 = arr4D[0][0][0].length;
            Arrays.fill(arr4D[0][0][0], 666);   
//        for (int[][][] arr3D : arr4D) {
//            for (int[][] arr2D : arr3D) {
//                for (int[] arr1D : arr2D) {
//                    for (int arr : arr1D) {
//                        //arr4D[][][][]= new int{  };
//                    }
//                }
//            }
//        }

    }
    // SKIP
    public static void simpleE(Object arr) {
        for (;;) {
            System.out.print(arr.toString());
        }
    }

    //  1  2  3  4
    //  5  6  7  8
    public static void showIntArr1_MinMax(int[][] arr) {
        int min_i = 0, min_j = 0, max_i = 0, max_j = 0;
        int min = arr[0][0];
        int max = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3s", arr[i][j]);
                if (min > arr[i][j]) {
                    min = arr[i][j];
                    min_i = i;
                    min_j = j;
                }
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
            System.out.println();
        }
        System.out.println("min: " + min + " в строке №: " + (min_i + 1) + " в столбце №: " + (min_j + 1)
                + "\n max: " + max + " в строке №: " + (max_i + 1) + " в столбце №: " + (max_j + 1));
    }

    // тоже оч. мудренный пример 
    public static void showIntMatrix(int size, int row, int[][] matrix) {
        for (int i = 0; i < 7 * size; i++) {
            System.out.print("-");
        }
        System.out.println("-");

        for (int i = 1; i <= matrix[row].length; i++) {
            System.out.printf("| %4d ", matrix[row][i - 1]);
        }
        System.out.println("|");

        if (row == size - 1) {
            // when we reach the last row,
            // print bottom line "---------"
            for (int i = 0; i < 7 * size; i++) {
                System.out.print("-");
            }
            System.out.println("-");
        }
    }

    // id    name   email    passw
    public static void showStrArr1(String[][] arr) {
        for (String[] i : arr) {
            for (String j : i) {
                System.out.printf("%3s", j + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    //  1  2  3  4
    //  5  6  7  8
    public static void showIntArr2_1(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) {
                System.out.printf("%3s", j);
                //System.out.printf("%4d", j);
            }
            System.out.println();
        }
        System.out.println();
    }

    // 1, 2, 3, 4, 5, 6, 7, 8, 
    public static void showIntArr2(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + ", ");
            }
        }
        System.out.println();
    }

    //  1  2  3  4
    //  5  6  7  8
    public static void showIntArr1_2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3s", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //  1   2   3   4   5   6   7   8	
    // самый странный вариант  с наполнением h
    public static void showIntArr1(int[][] arr) {
        for (int a = 0; a < arr.length; a++) {
            int[] h = arr[a];
            for (int u = 0; u < h.length; u++) {
                System.out.print(h[u] + "\t");
            }
        }
        System.out.println();
    }

    // good 
    public static void fillIntArr(int[][] arr) {
        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n;
                n++;
            }
        }
    }

    // bad my EXP
    public static void fillArr2(int[][] arr) {
        int n = 1;
        int i = 0;
        for (int[] k : arr) {
            for (int j : k) {
                arr[i][j] = n;
                n++;
            }
            i++;
        }
    }
}
