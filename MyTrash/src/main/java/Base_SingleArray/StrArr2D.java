/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_SingleArray;

/**
 *
 * @author MartyMcAir
 */
public class StrArr2D{
    public static void main(String[] args) {
        StrArr2D showStr = new StrArr2D();
        String[][] usersV1 = {{"id", "userName"},
        {"01", "Mikasa"}, {"02", "Angela"}, {"03", "Ilona"}, {"04", "Erik"}};
        showStr.showStr2DarrV2(usersV1);
    }

    public static void showExample() {
        int[][] myArr = {{1, 2, 3}, {4}, {5, 6, 7}, {8, 5}};
        myArr[0][2] = 42; // if [0][2] than 42
        int x = myArr[1][0]; // 4
        int y = myArr[2][1]; // 6
        int v = myArr[0][1]; // 2 
        int z = myArr[3][0]; // 8
        System.out.println(x);
        System.out.println(y);
        System.out.println(v);
        System.out.println(z);
    }
    
    public void showGeneralArr(){
        // <E> ?
    }
    // Обработка произвольного кол-ва объектов, строк
    public void showObjOptArr(Object... arr) {
        
    }

    // id	
    // userName
    public void printArr(String[][] puzzle) {
        for (String[] row : puzzle) {
            // System.out.println(Arrays.toString(row)+"\t"); // [id, userName]	
            for (String elem : row) {
                System.out.println(elem + "\t");
            }
        }
        System.out.println();
    }

    // id	userName	
    public void showStr2DarrV3(String[][] arr) {
        for (int a = 0; a < arr.length; a++) {
            String[] h = arr[a];
            for (int u = 0; u < h.length; u++) {
                System.out.print(h[u] + "\t");
            }
            System.out.print("\n");
        }
    }

    // id	userName	
    public void showStr2DarrV2(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // id	
    // userName	 
    public void showStr2DarrV1(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            // System.out.println(Arrays.toString(arr[i]) ); // [id, userName]
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

}
