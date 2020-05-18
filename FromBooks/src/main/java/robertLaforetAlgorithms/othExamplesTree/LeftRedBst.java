package robertLaforetAlgorithms.othExamplesTree;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.Objects;


public class LeftRedBst {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    // 	Ø https://ru.coursera.org/lecture/algorithms-part1/red-black-bsts-GZe13 - Video Eng =  RUS  subitles
    // https://algs4.cs.princeton.edu/41graph/
    public static void main(MysqlxDatatypes.Scalar.String[] args) {

        // loke at
        // https://github.com/TimeSooShort/AlgorithmLearning/tree/a04378551bd78a895ae176337855565ada7b2016/src/Algorithms4th/search
        LeftRedBst leftRedBst = new LeftRedBst();

        KeyForNode keyForNode = new KeyForNode(1);
        Value valueFirst = new Value("first value");
        Node nodeFirst = new Node(keyForNode, valueFirst, true);

        leftRedBst.put(nodeFirst, keyForNode, valueFirst);

//        leftRedBst.displayTree(nodeFirst);   // NPE
    }

    private Node put(Node h, KeyForNode key, Value val) {
        // for save balance 1 _ in BST Red-Black-Tree
        if (h == null) return new Node(key, val, RED); // insert at bottom (and color red)

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else if (cmp == 0) h.val = val;

        // and for save balance 2 3 4
        if ((isRed(h.right)) && !isRed(h.left)) h = rotateLeft(h); // lean left
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h); // balance 4-node
        if (isRed(h.left) && isRed(h.right)) flipColors(h); // split 4-node

        return h;
    }

    public Value get(KeyForNode key) {
        Node x = root;
        Value result = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) {
                result = x.val;
                break;
            }
        }
        return result;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED; // путь от h к его родителю теперь RED
        h.left.color = BLACK;  // а пути от его потомков к нему теперь BLACK
        h.right.color = BLACK;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right; // сохраняем в Tmp _ (будет будущим корнем)
        // присваиваем ссылке на прав узел текущего корня, ссылку на лев узел его правого под-узла (right child)
        h.right = x.left;  // с права от текущего корня, теперь находится левый-узел его под-right-child'a
        // у правого подузла текущ корня теперь потомок слева, в лице его корня, а сам потомок теперь явл. корнем
        // а предыдущий корень более не корень..
        x.left = h;
        x.color = h.color;
        h.color = RED;  // h теперь находится слева от корня x, а значит окрашиваем его в RED
        return x;
    }

    // my printTree
    public void displayTree(Node node) {
        if (node != null) {
            displayTree(node.left);
            System.out.println(node);
            displayTree(node.right);
        }
    }

    ///////////////// CLASS
    private static class Node {
        public KeyForNode key;
        public Value val;
        public Node left, right;
        public boolean color;   // color of parent link

        public Node(KeyForNode key, Value val, boolean red) {
            this.key = key;
            this.val = val;
            this.color = red;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", left=" + left.key +
                    ", right=" + right.key +
                    ", color=" + color +
                    '}';
        }
    }

    private static class Value {
        private String value;

        public Value(String value) {
            this.value = value;
        }
    }

    private static class KeyForNode {
        private int key;

        public KeyForNode(int key) {
            this.key = key;
        }

        public int compareTo(KeyForNode key) {
//            if (this.hashCode() > key.hashCode())
//                return 1;
//            if (this.hashCode() < key.hashCode())
//                return -1;
//            else return 0;
            // OR
            if (this.key > key.key)
                return 1;
            if (this.key < key.key)
                return -1;
            else return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof KeyForNode)) return false;
            KeyForNode that = (KeyForNode) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
