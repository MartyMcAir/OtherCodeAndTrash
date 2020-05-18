package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508.superMidChild2;

import java.util.ArrayList;
import java.util.List;

public class TmpSup1 {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        List<MiddleClazz2> listMid = new ArrayList<>(); // в find wrong argument for <SuperClazz2>
        listMid.add(new MiddleClazz2("name1"));
        listMid.add(new MiddleClazz2("name2"));
        listMid.add(new MiddleClazz2("name3"));
        find(listMid, new MiddleClazz2("name1"));
        find(listMid, new ChildClazz2("name3"));
        find(listMid, new SuperClazz2("name3")); // cannot be appealed for List<T> all

        /////////
        List<MiddleClazz2> listMid2 = new ArrayList<>();
        listMid2.add(new MiddleClazz2("mid 1"));
        listMid2.add(new MiddleClazz2("mid 2"));

        List<ChildClazz2> listChild2 = new ArrayList<>();
        listChild2.add(new ChildClazz2("child 1"));
        listChild2.add(new ChildClazz2("child 2"));

        List<SuperClazz2> listSup2 = new ArrayList<>();
        listSup2.add(new SuperClazz2("sup 1"));
        listSup2.add(new SuperClazz2("sup 2"));

        displayList(listMid2);
        displayList(listChild2);
        displayList(listSup2);


        copy2(listSup2, listMid2);
        copy2(listSup2, listChild2);
//        copy2(listMid2, listChild2); // compile err

        displayList2(new ArrayList<Number>());
        displayList2(new ArrayList<Integer>());
    }

    public static void displayList2(List<? extends Number> list) {
        for (Number n : list)
            System.out.println(n);
    }

    public static <T> void copy2(List<T> to, List<? extends T> from) {
//    public static <T extends SuperClazz2> void copy2(List<SuperClazz2> to, List<T> from) {
        to.add(from.get(0));
//        from.add(to.get(0));
    }

    //    public static <T> void displayList(List<SuperClazz2> list) { // сompile err for listMid2 and listChild2
//    public static <T> void displayList(List<T> list) { // всё ок
//        for (T t : list)
//    public static void displayList(List<?> list) { // всё ок
//        for (Object t : list) // но доступны методы только класс Object
    public static void displayList(List<? extends SuperClazz2> list) { // всё ок
        for (SuperClazz2 t : list) // но доступны методы только класс Object
            System.out.println(t);
    }

    //    public static void copy(List<? super MiddleClazz2> src, List<SuperClazz2> dest) { // err
    // указывает компилятору, что T extends SuperClazz2
//    public static <T extends SuperClazz2> void copy(List<T> src, List<SuperClazz2> dest) { // всё ок
//    public static void copy(List<SuperClazz2> src, List<SuperClazz2> dest) { // всё ок
    public static void copy(List<? extends SuperClazz2> src, List<? super SuperClazz2> dest) { // всё ок
        for (SuperClazz2 item : src) {
            dest.add(item);
        }
    }

    //    public static boolean find(List<SuperClazz2> all, SuperClazz2 sup) { // _ Compile Err
    public static boolean find(List<? extends SuperClazz2> all, SuperClazz2 sup) { // No Err
        // пример с дженерилизацией всего метода _ err for find(listMid, new SuperClazz2("name3"));
//    public static <T extends SuperClazz2> boolean find(List<T> all, T sup) { // No Err
        for (SuperClazz2 item : all) {
            if (item.getName().equals(sup.getName()))
                return true;
        }
        return false;
    }
}
