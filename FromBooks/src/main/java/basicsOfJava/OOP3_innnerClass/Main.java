/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.OOP3_innnerClass;

/**
 *
 * @author MartyMcAir
 */
public class Main {
    static String txt="статическая переменная";
    
    public static void main(String[] args) {
        AbsAnimals abs1, abs2;
        abs1 = new Cat("МяуУ");
        abs2 = new ChildAbs1("что-то кричит");

        abs1.doAny();
        abs1.doSound();
        System.out.println();

        abs2.doAny();
        abs2.doSound();
        System.out.println();
        
        Main m = new Main();
        m.runInnerClass(333, ", проверочный текст");
        System.out.println();
        
        C.getSt();
    }

    static class C {
        public static void getSt(){
            System.out.println(txt+" вызвана из вложенного статического класса "
                    + " статического метода getSt()");
        }
    }
    
    class A {
        int a;
        public void setA(int a){
            this.a=a;
        }
        public int getA(){
            return this.a;
        }
    }
    
    class B {
        String text;
        B(String text){
            this.text=text;
        }
        void show(){
            System.out.println("вложенный класс B "+text);
        }
    }

    public void runInnerClass(int a, String text) {
        A aa = new A();
        aa.setA(a);
        System.out.println("значение а: "+aa.getA());
        
        B bb = new B(text);
        bb.show();
        
        class D{
            static final String CONST = "статическая константа из D класса";
            String var = "статическая переменнная D класса", 
                    var2="класс D внутри метода runInnerClass()";
            void show(){
                System.out.println(CONST+"\n"+var+"\n"+var2);
            }
        }
        D dd = new D();
        dd.show();
    }
}
