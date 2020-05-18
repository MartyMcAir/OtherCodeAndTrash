/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_access;

/**
 *
 * @author MartyMcAir
 */
public class SuperClass {
    public String simpleSuper="Обычное поле класса SuperClass";
    public static String staticSuper="Статическое поле класса SuperClass";
    
    public void showSuper(){
        System.out.println("Метод showSuper() класса SuperClass");
    }
    public void showSuperForMyClass(){
        System.out.println("Метод showSuperClassMethod() класса SuperClass"+
                " Специально для вызова из подКласса");
    }
    public static void showSuper(String txt){
        System.out.println(txt+ " Метод showSuper() класса SuperClass ");
    }
}
