package Alishev;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = new Person();
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("Alishev.Person");
        Class personClass = Person.class;
//        printMethods(personClass);
//        printFields(personClass);
//        printPrivateFields(personClass);
//        printPrivateMethods(personClass);
//        printAnnotations(personClass); // не видит аннотаций


        Class<? extends Person> aClass = person.getClass();
        String methodName = "printAny", methodArguments = "Hello from invoked Method. Thanks for Reflection API.";
        Class<String> methodArgumentType = String.class;
        Method method = aClass.getMethod(methodName, methodArgumentType);

        Object o1 = aClass.getDeclaredConstructor().newInstance();
        method.invoke(o1, methodArguments); // запускаем полученный метод

//        originExamples(personClass);
    }

    public static void originExamples(Class personClass) {
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ", " + method.getReturnType() + ", "
                    + Arrays.toString(method.getParameterTypes()));
        }

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) System.out.println(field.getName() + ", " + field.getType());


        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations)
            if (annotation instanceof Override) System.out.println("Annotation Author contains");
    }

    public static void printAnnotations(Class personClass) {
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Deprecated)
                System.out.println(personClass.getClass() + " contains annotation is: Deprecated");
            System.out.println(annotation);
        }
    }

    public static void printFields(Class personClass) {
        Field[] fields = personClass.getFields();
        for (Field field : fields) printFields(field);
    }

    public static void printPrivateFields(Class personClass) {
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) printFields(field);
    }

    public static void printMethods(Class personClass) {
        Method[] methods = personClass.getMethods();
        for (Method method : methods) printMethods(method);
    }

    public static void printPrivateMethods(Class personClass) {
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method : declaredMethods) printMethods(method);
    }

    ////////////////////

    public static void printFields(Field field) {
        System.out.print("Type: " + field.getType() + " fieldName: " + field.getName());
        System.out.println("\n------------------------");
    }

    public static void printMethods(Method method) {
        System.out.println(method.getReturnType());
        System.out.println(Arrays.toString(method.getParameterTypes()));
    }
}
