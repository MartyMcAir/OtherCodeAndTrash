package robertLaforetAlgorithms.Tree;

public class Node {
    public Node root, leftChild, rightChild;
    public int key;
    public String value;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
//                "root=" + root +
//                ", leftChild=" + leftChild +
//                ", rightChild=" + rightChild +
//                ", key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
