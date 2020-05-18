/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_MatrixArr;

import java.util.Arrays;

/**
 *
 * @author MartyMcAir
 */
// From JavaRush and oth..
public class CanvasMatrixOperations {

    public static void main(String[] args) {
        CanvasMatrixOperations canvas = new CanvasMatrixOperations(6, 6);
        char[][] matrixN = canvas.getMatrix();
        for (int i = 0; i < matrixN.length; i++) {
            for (int j = 0; j < matrixN.length; j++) {
                matrixN[i][j] = 3;
            }
        }
        canvas.print();
    }

    // Он будет ответственным за "отрисовку" объектов.
    // С помощью его они будут отрисовывать себя.
    // Вернее даже на нем, но детали я сообщу позднее.
    private int height;
    private int width;
    private char[][] matrix;

    public CanvasMatrixOperations(int width, int height) {
        this.height = height;
        this.width = width;
        this.matrix = new char[height + 2][width + 2];
    }

    public void print() {
        // https://javarush.ru/tasks/com.javarush.task.task24.task2413.big11#discussion
        System.out.println("for( ..for(..). )_______________");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("forEach__________________________");
        // OR
        for (char[] chars : matrix) {
            System.out.println(new String(chars));
        }
        // OR
        System.out.println(" Arrays.stream(matrix)___________");
        Arrays.stream(matrix)
                .map(String::new)
                .forEach(System.out::println);
    }

    public void clear() { // Этот метод будет очищать матрицу, чтобы на ней снова можно было рисовать.
        this.matrix = new char[height + 2][width + 2];
    }

    /////////
    public void setPoint(double x, double y, char c) {
        // ничего не делать, если x < 0 или y < 0 или y >= matrix.length или x >= matrix[0].length
        if (x < 0 | y < 0 | y >= matrix.length | x >= matrix[0].length) {
        } else {
            // Разница в том, что во втором примере перед приведением типа выполняется округление.
            //Если приводить к целому, число 3.7 без округления и предварительно выполнив округление,
            // в результате получим 3 и 4 соответственно.
            this.matrix[(int) Math.round(y)][(int) Math.round(x)] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    /////////////////////
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
