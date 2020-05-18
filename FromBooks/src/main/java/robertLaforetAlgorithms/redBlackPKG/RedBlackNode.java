package robertLaforetAlgorithms.redBlackPKG;

class RedBlackNode {
    Comparable element;    // The data in the node
    RedBlackNode left;       // Left child
    RedBlackNode right;      // Right child
    int color;      // Color

    // Constructors
    RedBlackNode(Comparable theElement) {
        this(theElement, null, null);
    }

    RedBlackNode(Comparable theElement, RedBlackNode lt, RedBlackNode rt) {
        element = theElement;
        left = lt;
        right = rt;
        color = RedBlackTree.BLACK;
    }
}
