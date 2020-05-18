/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

import java.text.DateFormatSymbols;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author MartyMcAir
 */
public class cls7Seven {

    public static void main(String[] args) throws CloneNotSupportedException {
//        showCloneableObj(); // clone err
        showCloneListTime();
    }

    static void showCloneListTime() {
        cloneListTime clt = new cloneListTime();
        cloneListTime clt2 = (cloneListTime) clt.getCopyObj();
        // выдает NullPointer
        cloneListTime clt3 = (cloneListTime) clt.clone();
        ZonedDateTime zdt = ZonedDateTime.now();

        DateFormatSymbols dfs = clt.getDFS();
        dfs.setMonths(new String[]{"pn", "vt", "sr", "cht", "pt", "sb", "vs"});

        System.out.println(Arrays.toString(dfs.getShortWeekdays()));

        System.out.println(Arrays.toString(clt.getDFSWeekDays()));

        System.out.println(clt.getDate());
        clt.setDateMonth(3);
        System.out.println(clt.getDate());

        System.out.println("clt2.getDate(): " + clt2.getDate());
    }

    static void showCloneableObj() {
        cls7Seven cls = new cls7Seven();
//        cls.objectShow();
        clsClone cl1 = new clsClone(10);
//        clsClone cl2 = cl1.clone();
//        System.out.println("cl1.getB(): "+cl1.getB());
//        System.out.println("cl2.getB(): "+cl2.getB());

        A acl1 = new A(10);
//        A acl2 = (A) acl1.clone();
        System.out.println("\nacl1.getD(): " + acl1.getD());
//        System.out.println("acl2.getD(): "+acl2.getD());

        Derived dv1 = new Derived();
        Derived dv2 = dv1.copy();
        System.out.println("dv1.getA(): " + dv1.getA()); // 33
        dv2.setA(999); // изменяем объект
        System.out.println("dv2.getA(): " + dv2.getA()); // 999
        System.out.println("dv1.getA(): " + dv1.getA()); // 33 _ исходный объект не изменился

        System.out.println("\nStudent from book: Java методы программирования");
        Student obj = new Student();
        System.out.println("Простое клонирование obj.getId(): " + obj.getId());
        mutation(obj);
        System.out.println("obj.getId(): " + obj.getId());

        Student2 st2_1 = new Student2();
        System.out.println("\nКлонирование с учетом полей объектных типов "
                + "\n_ st2.getId(): " + st2_1.getId()); // 77
        // если в переопределенном методе clone в типе возвращаемого
        // указан класс Object, то при клонировании следует делать приведение типа
        // к клонируемому объекту
        Student2 st2_2 = (Student2) st2_1.clone();
        st2_2.setId(999);
        System.out.println("изменен объект клона, но не исходного объекта "
                + "st2.getId(): " + st2_2.getId()); // 999
        st2_1.addElementVector(777);
        st2_1.addElementVector(999);
//        addElementVector(888);
        Vector<Integer> v = st2_1.getVector();
        System.out.println("Изменили изменяемое поле исходного объекта: " + v);
    }

    static void addElementVector(int a) {
        Student2 st = new Student2();
        st.addElementVector(a);
    }

    private static void mutation(Student p) {
        try {
            p = (Student) p.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        p.setId(1000);
        System.out.println("p.getId(): " + p.getId());
    }

    void objectShow() {
        System.out.print("clsModelObj get & set _ obj instanceof: ");
        clsModelObj cls = new clsModelObj();
        cls.setObj("String");
        System.out.println((String) cls.getObj());
        cls.setObj(13.3);

        System.out.println("В случае если приведение типа будет не к тому  типу"
                + ", то это вызовет исключение err _ в этом случае можно "
                + "\n прибегнуть к предварительной проверке instanceof ");
        System.out.print("(VariableType) cls.getObj(): ");
        if (cls.getObj() instanceof String) {
            System.out.print((String) cls.getObj() + "\n");
        } else if (cls.getObj() instanceof Integer) {
            System.out.print((int) cls.getObj() + "\n");
        } else {
            System.out.println("Ни одной проверки instanceof не подходит: "
                    + cls.getObj().getClass().getName() + "\n");
        }
        System.out.println("cls.toString() _: " + cls.toString());

        System.out.println("\nclsPoint _ @Override equals _ hashcode ==!?: ");
        clsPoint p1 = new clsPoint(1, 2);
        clsPoint p2 = new clsPoint(1, 2);
        clsPoint p3 = new clsPoint(3, 1);
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p3.hashCode(): " + p3.hashCode());

        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
    }

}
