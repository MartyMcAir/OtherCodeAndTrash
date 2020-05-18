/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon2;

import java.util.Arrays;

/**
 *
 * @author MartyMcAir
 */
public class clsRun {

    public static void main(String[] args) throws CloneNotSupportedException {
        clsRun cls = new clsRun();
//        cls.showCloneProbleam();
//        cls.showUser();
//        cls.showUser1();
//        cls.showBook();
//        cls.showBook1();
        cls.showBookBaseProblem();

    }

    void showBookBaseProblem() {
        System.out.println("Суть проблемы, при отсутствии возможности"
                + ", клонирования объекта");
        BookBase thor = new BookBase("Thor", "1500");
        thor.setContents(new String[]{"Odin", "Hiendal", "Valkiriya"});
        System.out.print("Создан obj thor: ");
        thor.displayBookName();
        // Создан obj thor: book: Thor, author: 1500
        //___ and arr: [Odin, Hiendal, Valkiriya]
        BookBase thanos = thor; // присваиваем объект
        thanos.setName("Thanos");
        thanos.setAuthor("800");

        System.out.print("\nСоздан obj thanos: ");
        thanos.setContents(new String[]{"Nebula", "Gomora", "Titan"});
        thanos.displayBookName();
        // Создан obj thanos: book: Thanos, author: 800
        // ___ and arr: [Nebula, Gomora, Titan]
        System.out.print("\nobj thor после изменений объекта thanos _ "
                + "оригинальный объект изменился\n: ");
        thor.displayBookName();
        // obj thor после изменений объекта thanos _ оригинальный объект изменился
        // : book: Thanos, author: 800
        // ___ and arr: [Nebula, Gomora, Titan]
    }

    void showBook1() throws CloneNotSupportedException {
        Book1 java = new Book1("java SE", "Java Master");
        java.setContents(new String[]{"java step1", "step2", "step3"});
        Book1 sql = java.clone();

        System.out.print("Создан объект java obj: ");
        java.displayBookName();
        System.out.print("Склонирован объект java в объект sql obj: ");
        sql.displayBookName();

        sql.setName("SQL Base");
        sql.setAuthor("SQL Master");
        sql.setContents(new String[]{"sql step1", "step2", "step3"});

        System.out.print("\nКлон sql obj изменен: ");
        sql.displayBookName();
        System.out.print("Оригинальный объект не изменен =profit _ java obj:");
        java.displayBookName();
    }

    void showBook() throws CloneNotSupportedException {
        System.out.println("Суть проблемы поверхностного клонирования, т.е."
                + " \n т.е. клонирование объекта без учета его объектных полей.");
        Book java = new Book("java SE", "Java Master");
        java.setContents(new String[]{"java step1", "step2", "step3"});
        Book sql = java.clone();

        System.out.print("Создан объект java obj: ");
        java.displayBookName();
        System.out.print("Склонирован объект java в объект sql obj: ");
        sql.displayBookName();

        sql.setName("SQL Base");
        sql.setAuthor("SQL Master");
        sql.setContents(new String[]{"sql step1", "step2", "step3"});

        System.out.print("\nКлон sql obj изменен: ");
        sql.displayBookName();
        System.out.print("Оригинальный объект изменен, а точнее его объектное поле "
                + "\n author (с массивом такх проблем нет) _ java obj:");
        java.displayBookName();
    }

    void showUser1Problem() throws CloneNotSupportedException {
        User1 thor = new User1();
        // при использовании clone, объект thanos и его изменения не изменяют
        // объект thor
        User1 thanos = thor.clone();
        thor.setName("Thor");
        thor.setAge(1600);
        System.out.println("thor.getName(): " + thor.getName()
                + ", age: " + thor.getAge()); // thor.getName(): Thor, age: 1600

        thanos.setName("Thanos");
        thanos.setAge(800);
        System.out.println("thanos.getName(): " + thanos.getName()
                + ", age: " + thanos.getAge()); // thanos.getName(): Thanos, age: 800
        System.out.println("thor.getName(): " + thor.getName()
                + ", age: " + thor.getAge()); // thor.getName(): Thor, age: 1600
    }

    void showCloneProbleam() {
        System.out.println("Суть проблемы, при отсутствии возможности"
                + ", клонирования объекта");
        Person tom = new Person();
        tom.setName("Tom");
        tom.setAge(28);
        tom.showPersonalData(); // name: Tom, age: 28

        Person djeck = tom; // присваивем джеку тома
        djeck.setName("Djeck");
        djeck.setAge(33);
        djeck.showPersonalData(); // name: Djeck, age: 33

        System.out.println("При изменении объекта djeck, "
                + "объект tom так же изменился _ tom.showPersonalData(): ");
        tom.showPersonalData(); // name: Djeck, age: 33
    }

    void showExt() throws CloneNotSupportedException {
        // демонстрация наследования класса при неправлином клонировании супер класса
        // через new.. приводит к ошибкам для классов его наследующих т.е. для clsExt()
        clsExt clsE = new clsExt();
        clsExt clsE2 = (clsExt) clsE.clone();
        System.out.println(clsE2.getStr());
    }

    void showUser1() throws CloneNotSupportedException {
        User1 cls = new User1();
        System.out.println("Original cls: " + Arrays.toString(cls.getStrArr()));
        cls.setStrArr(new String[]{"line one", "line two", "line three"});
        System.out.println("Orihinal cls changes: "
                + Arrays.toString(cls.getStrArr()));

        User1 clone = cls.clone();
        System.out.println("\nДанные clone клона" + Arrays.toString(clone.getStrArr()));
        clone.setStrArr(new String[]{"str one", "str two", "str three"});
        System.out.println("Данные clone клона после изменения"
                + Arrays.toString(clone.getStrArr()));
        System.out.println("\nOriginal cls changes _ без изменений: "
                + Arrays.toString(cls.getStrArr()));
    }

    void showUser() throws CloneNotSupportedException {
        System.out.println("Суть проблемы, при отсутствии возможности"
                + ", клонирования объекта");
        User thor = new User();
        // при использовании clone, объект thanos и его изменения не изменяют
        // объект thor
        User thanos = thor;
        thor.setName("Thor");
        thor.setAge(1600);
        System.out.println("thor.getName(): " + thor.getName()
                + ", age: " + thor.getAge()); // thor.getName(): Thor, age: 1600

        thanos.setName("Thanos");
        thanos.setAge(800);
        System.out.println("thanos.getName(): " + thanos.getName()
                + ", age: " + thanos.getAge()); // thanos.getName(): Thanos, age: 800
        System.out.println("thor.getName(): " + thor.getName()
                + ", age: " + thor.getAge()); // thor.getName(): Thor, age: 1600

        User thanosClone = thor.clone();
        thor.setName("Thor");
        thor.setAge(1500);
        System.out.println("\n данные объекта thor после их обновления "
                + "thor.getName(): " + thor.getName() + ", age: " + thor.getAge());

        thanosClone.setName("Thanos");
        thanosClone.setAge(800);
        System.out.println("Клон объекта thanos, thanosClone.getName(): " // Thor, age: 1500
                + thanosClone.getName() + ", age: " + thanosClone.getAge()); // Thanos, age: 800
        System.out.println("Клон не повлиял на объект thor _ thor.getName(): "
                + thor.getName() + ", age: " + thor.getAge()); // Thor, age: 1500
    }
}
