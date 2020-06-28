package Alishev;

public @interface MyAnnotation {
    // объявляются как методы а используются как поля
    String name() default "Some Name";
    int dateOfBirth() default 2000;
}
