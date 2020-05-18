/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step2Two;

/**
 *
 * @author MartyMcAir
 */
public class zclsAbsExt extends zclsAbstract{
    // класс наследующий абстрактный класс должен переопределять 
    // все абстрактные методы наследуемого класса
    
    zclsAbsExt(){}
    
    zclsAbsExt(String mmm){
        super(mmm);   // передаем в коснтуктор супер класса переменную mmm
    }
    
    // переопределение абстрактных методов называется
    // = реализация абстрактных методов
    @Override
    void setAbsM(String m) {
        this.m=m;
    }

    @Override
    String getAbsM() {
        return this.m;
    }

    @Override
    void absMethod() {
        System.out.println("absMethod from clsAbsExt extends clsAbstract");
    }

    @Override
    void absMethod(String str) {
        System.out.println("absMethod from clsAbsExt extends clsAbstract str: "
                +str);
    }

    @Override
    void absMethod(String str, int num) {
        System.out.println("absMethod from clsAbsExt extends clsAbstract str: "
                +str+", num: "+num);
    }
    
    public static void main(String[]args){
        zclsAbsExt cls = new zclsAbsExt();
        cls.setAbsM("Строка из clsAbsExt extends clsAbstract");
        System.out.println("cls.getAbsM(): "+cls.getAbsM()+"\n");
        
        cls.showM();
        cls.additionalMethod();
        
        System.out.println("\nДоступ через переменную абстрактного класса,"
                + " доступны только его методы и переменные");
        zclsAbstract abs = new zclsAbsExt();
        abs.setAbsM("test");
        System.out.println("abs.getAbsM(): "+abs.getAbsM());
        
        zclsAbsExt cls2 = new zclsAbsExt("\n\nпроверочная строка с передачей"
                + " в абстрактный супер класс,\n через ключ слово super()"
                + " в конструкторе");
        cls2.showM();
    }
    
    void additionalMethod(){
        System.out.println("--- метод не доступен из абстрактной переменной ---");
    }
}
