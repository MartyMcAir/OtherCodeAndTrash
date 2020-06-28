package Alishev;

// https://www.udemy.com/course/javarussia/learn/lecture/15005548#overview

@MyAnnotation
public class TestAnnotation {
    @MyAnnotation
    private String name;

    @MyAnnotation
    public void Test() {
    }

    @MyAnnotation
    public void test(@MyAnnotation int value) {
        @MyAnnotation String localVar = "Hello";
    }

    @MyAnnotation
    public static void main(@MyAnnotation String[] args) {

    }
}
