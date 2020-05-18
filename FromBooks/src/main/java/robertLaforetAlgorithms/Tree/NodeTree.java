package robertLaforetAlgorithms.Tree;

public class NodeTree {
    public Node mainNode;

    public Node insert(int key, String value) {
        Node newNode = new Node(key, value);

        if (newNode.root == null) { // если это первая нода
            newNode.root = newNode;
            mainNode = newNode;
        } else {
            Node current = mainNode;
            Node parent;

            while (true) {
                parent = current;
                if (newNode.key < current.key) {
                    current = current.leftChild; // переключение current на лев. ветвь

                    if (current == null) {
                        parent.leftChild = newNode;
                        return newNode;
                    }
                } else { // key current больше или равно, ключу добавляемой Ноды
                    current = current.rightChild; // переключение current на прав. ветвь

                    if (current == null) { // если достигут конец цепочки
                        parent.rightChild = newNode;
                        return newNode;
                    }
                }
            }
        }
        return newNode;
    }

    // Симметричный обход дерева
    public void displayTree(Node localNode) { // показ узлов, начиная от localNode
        if (localNode != null) {
            displayTree(localNode.leftChild);
            System.out.println(localNode);
            displayTree(localNode.rightChild);
        }
    }
}
