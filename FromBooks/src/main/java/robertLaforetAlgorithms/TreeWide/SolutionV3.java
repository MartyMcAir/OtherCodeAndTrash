package robertLaforetAlgorithms.TreeWide;

import java.util.List;

public class SolutionV3 {
    // https://javarush.ru/quests/lectures/questcollections.level01.lecture15
    public static void main(String[] args) {
        List<String> list = new CustomTreeV3();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        CustomTreeV3.Entry<String> entryByString = ((CustomTreeV3) list).getEntryByString("3");
//        System.out.println(entryByString);

//        ((CustomTree) list).getListChildesByEntry(entryByString).forEach(v -> System.out.println(v));

//        list.remove("3");
//        ((CustomTree) list).display(((CustomTree) list).getRoot(), "root");

//        list.add("20");
//        System.out.println(((CustomTree) list).getParent("20"));

        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTreeV3) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTreeV3) list).getParent("20"));

        list.remove("3");
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTreeV3) list).getParent("8"));

        list.add("16");  // !--------------------
        System.out.println("The expected parent is 9. The actual parent is " + ((CustomTreeV3) list).getParent("16"));

        list.remove("4");
        list.remove("5");
        list.remove("6");
        System.out.println("Expected: true. Actual: " + list.add("20"));

        System.out.println(list.size());
        // !-------------------------
        System.out.println("The expected parent is 1. The actual parent is " + ((CustomTreeV3) list).getParent("20"));
    }
}
