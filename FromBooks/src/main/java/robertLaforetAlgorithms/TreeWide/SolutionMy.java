package robertLaforetAlgorithms.TreeWide;

import java.util.List;

public class SolutionMy {
    public static void main(String[] args) {
        Entry<String> root = new Entry<>("0");
        CustomTreeMy2 myTree2 = new CustomTreeMy2(root);
        // 0
        myTree2.add("1"); // left
        myTree2.add("2"); // right

        // 1
        myTree2.add("3"); // left
        myTree2.add("4"); // right

        // 2
        myTree2.add("5"); // left
        myTree2.add("6"); // right

        myTree2.displayTree(root, "root");

//        System.out.println(myTree2.allVertexIsFull());

//        for (int i = 1; i < 16; i++) {
//            myTree2.add(String.valueOf(i));
//        }

//        System.out.println("The myTree2 size is " + myTree2.size());
//        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) myTree2).getParent("8"));
//        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) myTree2).getParent("20"));

//        tt();
    }

    public static void tt() {
        List<String> list = new CustomTree(new CustomTree.Entry<>("0"));
//        list.listIterator()

//        for (int i = 1; i < 16; i++) {
//            list.add(String.valueOf(i));
//        }

//        System.out.println("The list size is " + list.size());
//        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
//        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));
    }
}
