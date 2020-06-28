package Alishev;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// https://www.udemy.com/course/javarussia/learn/lecture/15005556#overview
// можно юзать аннотацию только для методов и TYPE - это класс интерф перечисление
//@Target({ElementType.METHOD, ElementType.TYPE})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)  // полиика удержания получаем доступ через рефлексию во время выполнения проги
public @interface MethodInfo {
    String author() default  "Neil";
    int dateCreation() default 2020;
    String purpose(); // цель метода
}
