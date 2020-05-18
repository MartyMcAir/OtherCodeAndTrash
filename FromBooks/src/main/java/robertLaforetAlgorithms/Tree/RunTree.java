package robertLaforetAlgorithms.Tree;

public class RunTree {
    public static void main(String[] args) {
        Node_v2 node_v2 = new Node_v2(63, "root is 63");
        //        node_v2.insert(new Node_v2(30, " is 30 left"))
        //                .insert(new Node_v2(63, " is 63 right"));

        //        node_v2.insert(new Node_v2(27, " is 27 left"));
        //        node_v2.insert(new Node_v2(13, " is 13 left"));
        //        node_v2.insert(new Node_v2(26, " is 26 right"));
        //        node_v2.insert(new Node_v2(33, " is 33 left"));
        //        node_v2.insert(new Node_v2(58, " is 58 right"));
        //        node_v2.insert(new Node_v2(60, " is 60 right"));
        //        node_v2.insert(new Node_v2(57, " is 57 left"));

        Node_v2 node_13 = new Node_v2(13, " is 13");
        Node_v2 node_26 = new Node_v2(26, " is 26");
        Node_v2 node_27 = new Node_v2(27, " is 27");
        Node_v2 node_33 = new Node_v2(33, " is 33");
        Node_v2 node_51 = new Node_v2(51, " is 51");
        Node_v2 node_57 = new Node_v2(27, " is 57");
        Node_v2 node_58 = new Node_v2(58, " is 58");
        Node_v2 node_60 = new Node_v2(68, " is 68");

        // only left way
        node_v2.insert(node_33);
        node_v2.insert(node_27);
        node_v2.insert(node_26);
        node_v2.insert(node_13);

//        node_27.insert(node_13);
//        node_13.insert(node_26);
//
//        node_27.insert(node_51);
//        node_51.insert(node_33);
//        node_51.insert(node_58);
//        node_58.insert(node_57);
//        node_58.insert(node_60);

        node_v2.displayTree(node_v2, "___ my root");

//        System.out.println("------------------------------------ _ setNodeNullByKey: ");
//        node_v2.getNodeByKey(26).showAllFields();
//        node_v2.setNodeNullByKey(26);

        // Выводим все ноды дерева в консоль
//        node_v2.displayTree(node_v2, "___ my root");
//        node_v2.displayPostOrder(node_v2, "___ my root");
//        node_v2.displayPreOrder(node_v2, "___ my root");

//        System.out.println("------------------------------------ _ showAllFields (node is Cut..): ");
//        node_26.showAllFields();
        System.out.println("------------------------------------ _ getSuccessorRL: ");
//        Node_v2 successorRL = node_v2.getSuccessorRL(node_27);
//        successorRL.showAllFields();
//        node_26.showAllFields();
        node_v2.deleteByKeyRL(26);

        System.out.println("------------------------------------ _ deleteSingleNodeAndReinsertChild_ByKey: ");
//        node_v2.deleteSingleNodeAndReinsertChild_ByKey(26);
        node_v2.displayTree(node_v2, "root");

//        node_26.setFullNullByKey(27);
//        node_v2.displayTree(node_v2, "___ my root");
//        node_26.showAllFields();
//        node_v2.getListChildByNode(node_33).forEach(v -> System.out.println(v));

        // выводи минимал и максимал значения
//        System.out.println(node_v2.getMinNode());  // 13
//        System.out.println(node_v2.getMaxNode()); // 68

        node_26.showAllFields();   // вывод всех полей узла _ для проверки

//        runNodeTree();
    }

    private static void runNodeTree() {
        NodeTree tree = new NodeTree();
        Node root = tree.insert(53, "is 53 root");
        tree.insert(30, "is 30 left");
        tree.insert(14, "is 14 left");
        tree.insert(9, "is 9 left");
        tree.insert(39, "is 39 right");
        tree.insert(34, "is 34 left");
        Node last = tree.insert(47, "is 47 right");


//        tree.displayTree(last);/
        System.out.println(root.root);
        System.out.println(root.leftChild);
        System.out.println(root.rightChild);
    }
}
