package robertLaforetAlgorithms.redBlackPKG;
// CONSTRUCTION: with a negative infinity sentinel
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print all items
// ******************ERRORS********************************
// Exceptions are thrown by insert if warranted and remove.

/**
 * Implements a red-black tree.
 * Note that all "matching" is based on the compareTo method.
 *
 * @author Mark Allen Weiss
 */
// http://java-tips.org/java-se-tips-100019/24-java-lang/1904-red-black-tree-implementation-in-java.html
public class RedBlackTree {
    private RedBlackNode header;
    private static RedBlackNode nullNode;
    public static final int BLACK = 1;    // Black must be 1
    public static final int RED = 0;
    private static RedBlackNode current;  // Used in insert routine and its helpers..
    private static RedBlackNode parent;
    private static RedBlackNode grand;
    private static RedBlackNode great;

    static { // Static initializer for nullNode
        nullNode = new RedBlackNode(null);
        nullNode.left = nullNode.right = nullNode;
    }

    public RedBlackTree() {   // Construct the tree.
        header = new RedBlackNode(null);
        header.left = header.right = nullNode;
    }

    /**
     * Insert into the tree.
     *
     * @param item the item to insert.
     * @throws DuplicateItemException if item is already present.
     */
    public void insert(Comparable item) {
        current = parent = grand = header;
        nullNode.element = item;

        while (compare(item, current) != 0) {
            great = grand;
            grand = parent;
            parent = current;
            current = compare(item, current) < 0 ?
                    current.left : current.right;

            // Check if two red children; fix if so
            if (current.left.color == RED && current.right.color == RED)
                handleReorient(item);
        }

        // Insertion fails if already present
        if (current != nullNode)
            throw new DuplicateItemException(item.toString());
        current = new RedBlackNode(item, nullNode, nullNode);

        // Attach to parent
        if (compare(item, parent) < 0)
            parent.left = current;
        else
            parent.right = current;
        handleReorient(item);
    }

    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     *
     * @param item the item being inserted.
     */
    private void handleReorient(Comparable item) {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if (parent.color == RED)   // Have to rotate
        {
            grand.color = RED;
            if ((compare(item, grand) < 0) !=
                    (compare(item, parent) < 0))
                parent = rotate(item, grand);  // Start dbl rotate
            current = rotate(item, great);
            current.color = BLACK;
        }
        header.right.color = BLACK; // Make root black
    }

    ///////////// rotate methods..

    /**
     * Internal routine that performs a single or double rotation.
     * Because the result is attached to the parent, there are four cases.
     * Called by handleReorient.
     *
     * @param item   the item in handleReorient.
     * @param parent the parent of the root of the rotated subtree.
     * @return the root of the rotated subtree.
     */
    private RedBlackNode rotate(Comparable item, RedBlackNode parent) {
        if (compare(item, parent) < 0)
            return parent.left = compare(item, parent.left) < 0 ?
                    rotateWithLeftChild(parent.left) :  // LL
                    rotateWithRightChild(parent.left);  // LR
        else
            return parent.right = compare(item, parent.right) < 0 ?
                    rotateWithLeftChild(parent.right) :  // RL
                    rotateWithRightChild(parent.right);  // RR
    }

    // Rotate binary tree node with left child.
    private static RedBlackNode rotateWithLeftChild(RedBlackNode k2) {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    // Rotate binary tree node with right child.
    private static RedBlackNode rotateWithRightChild(RedBlackNode k1) {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }


    ///////// find min max ..

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public Comparable find(Comparable x) {
        nullNode.element = x;
        current = header.right;

        for (; ; ) {
            if (x.compareTo(current.element) < 0)
                current = current.left;
            else if (x.compareTo(current.element) > 0)
                current = current.right;
            else if (current != nullNode)
                return current.element;
            else
                return null;
        }
    }

    /**
     * Find the smallest item  the tree.
     *
     * @return the smallest item or null if empty.
     */
    public Comparable findMin() {
        if (isEmpty())
            return null;

        RedBlackNode itr = header.right;
        while (itr.left != nullNode)
            itr = itr.left;
        return itr.element;
    }

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item or null if empty.
     */
    public Comparable findMax() {
        if (isEmpty())
            return null;

        RedBlackNode itr = header.right;
        while (itr.right != nullNode)
            itr = itr.right;
        return itr.element;
    }

    //////// Empty
    public void makeEmpty() {   // Make the tree logically empty.
        header.right = nullNode;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return header.right == nullNode;
    }

    ////////////////////////// methods who's don't complicated //////////////////

    /**
     * Compare item and t.element, using compareTo, with
     * caveat that if t is header, then item is always larger.
     * This routine is called if is possible that t is header.
     * If it is not possible for t to be header, use compareTo directly.
     */
    private final int compare(Comparable item, RedBlackNode t) {
        if (t == header)
            return 1;
        else
            return item.compareTo(t.element);
    }

    /**
     * Remove from the tree.
     *
     * @param x the item to remove.
     * @throws UnsupportedOperationException if called.
     */
    public void remove(Comparable x) {
        throw new UnsupportedOperationException();
    }

    /////// print
    public void printTree() { // Print all items.
        printTree(header.right);
    }

    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the tree.
     */
    private void printTree(RedBlackNode t) {
        if (t != nullNode) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }
}