package Arithmetic;

/**
 * Created by vitaly on 24/09/16.
 */


// from https://stepik.org/lesson/12769/step/7?unit=3117
// and ... modific..
// Shape - общий для всех фигур
public class Shape {
    private final Color color;

    public Shape(Color color) { this.color = color; }

    public Color getColor() { return color; }
    // метод вычисления площади
    public double getArea() { return Double.NaN; }
    // метод вычисления периметра
    // метод вычисления длинны двух точек на фигуре
}
