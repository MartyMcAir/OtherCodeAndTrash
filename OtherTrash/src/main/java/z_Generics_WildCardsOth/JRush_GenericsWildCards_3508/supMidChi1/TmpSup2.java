package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508.supMidChi1;

import z_Generics_WildCardsOth.JRush_GenericsWildCards_3508.TestClass;

import java.util.ArrayList;
import java.util.List;

public class TmpSup2 {
    public static void main(String[] args) {
//        run();
        boundedType();
    }

    private static void boundedType() {
        TestClass testClass = new TestClass();
        Container<SuperClazz> container1 = new Container<>("container1");
        Container<MiddleClazz> container2 = new Container<>("container2");
        Container<ChildClazz> container3 = new Container<>("container3");
//        Container<String> container4 = new Container<>("container4"); // is not within its bound; should extend
        System.out.println(container1);
        System.out.println(container2);
        System.out.println(container3);
        System.out.println(container1.getT());   // null
    }

    private static void run() {
        List<String> listStr = new ArrayList<>();
        listStr.add("one");
//        listStr.add(new Object()); // // cannot be appealed
//        listStr.add(2); // cannot be appealed

        List<MiddleClazz> listLevels = new ArrayList<>();
        listLevels.add(new ChildClazz());  // good
        listLevels.add(new MiddleClazz());
//        listLevels.add(new SuperClazz());  // cannot be appealed
        listLevels.forEach(v -> System.out.println(v));


        List<? extends RuntimeException> listExtends = new ArrayList<>();
//        listExtends.add(new RuntimeException());  // cannot be appealed ___ WTF!?
//        listExtends.add(new Exception());  // cannot be appealed
//        listExtends.add(new NullPointerException());  // cannot be appealed
//        listExtends.add(new Object());  // cannot be appealed

        List<? extends MiddleClazz> listWildsCardsExt = new ArrayList<>();
//        listWildsCardsExt.add(new MiddleClazz());  // cannot be appealed ___ WTF!?
//        listWildsCardsExt.add(new ChildClazz());  // cannot be appealed
//        listWildsCardsExt.add(new SuperClazz());  // cannot be appealed

        /////////////////////
        List<? super Exception> listSuper = new ArrayList<>(); // пропуск всех наследников класса Exception
        listSuper.add(new Exception());
        listSuper.add(new RuntimeException());
        listSuper.add(new NullPointerException());
//        listSuper.add(3);   // cannot be appealed
//        listSuper.add(new Object());   // cannot be appealed

        List<? super MiddleClazz> listWildsCards = new ArrayList<>();
        listWildsCards.add(new MiddleClazz());
        listWildsCards.add(new ChildClazz());
//        listWildsCards.add(new SuperClazz());   // cannot be appealed
//        listWildsCards.add(3);  // cannot be appealed
    }

}
