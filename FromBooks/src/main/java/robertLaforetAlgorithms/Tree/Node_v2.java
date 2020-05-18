package robertLaforetAlgorithms.Tree;

import java.util.ArrayList;
import java.util.List;

public class Node_v2 {
    public static volatile Node_v2 root = null; // root один на всех
    public Node_v2 leftChild, rightChild, parent;
    public int key, level = 0, levelCounter = 0;
    public String value;

    public Node_v2(int key, String value) {
        this.key = key;
        this.value = value;
        if (root == null) { // если это первая нода
            root = this;
            this.parent = this;
            this.level = levelCounter++;
        }
    }

    public Node_v2 insert(Node_v2 newNode) {
        Node_v2 current = root, parent;

        while (true) {
            // сохраняем в parent, на случай если найдено пуст. место,
            // что бы была возможность указать на родителя пустого места (null)
            parent = current;
            newNode.parent = current; // указываем ссылку на родительский узел
            newNode.level = levelCounter;

            if (newNode.key < current.key) {
                current = current.leftChild; // переключение current на лев. ветвь
                if (current == null) { // если текущ null
                    parent.leftChild = newNode; // то родитель текущего т.е. leftChild..
                    return parent;
                }
            } else { // key current больше или равно, ключу добавляемой Ноды
                current = current.rightChild; // переключение current на прав. ветвь
                if (current == null) { // если достигут конец цепочки
                    parent.rightChild = newNode;
                    return parent;
                }
            }
            // относительно не верный подсчет и сильно неверный при deleteSingleNodeAndReinsertChild_ByKey(..)
            levelCounter++;
        }
    }

    public Node_v2 getNodeByKey(int key) {
        Node_v2 current = root;
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            if (key < current.key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return null;
    }

    public Node_v2 getMinNode() {
        Node_v2 current = root, last = null;
        while (current != null) { // а в примере с книги вместо while - if - и это не work's
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node_v2 getMaxNode() {
        Node_v2 current = root, last = null;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    ///////////////////////////////////////////////////////
    // Delete Methods from book _ стр. 369, что-то здесь не-то _ т.к. удаляет ещё один лишний..
    public boolean deleteByKeyRL(int key) {
        Node_v2 current = root;
        Node_v2 parent = root;
        boolean isLeftChild = true;
        while (current.key != key) {
            // если узел НЕ имеет, НИ одного потомка
            parent = current;
            if (key < current.key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {  // если узел не найден
                return false;
            }

            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;

            // если узел имеет одного потомка
            if (current.rightChild == null)
                if (current == root)
                    root = current.leftChild;
                else if (isLeftChild)
                    parent.leftChild = current.leftChild;
                else
                    parent.rightChild = current.leftChild;
                // если нет левого потомка, узел заменяетсяправы поддеревом
            else if (current.leftChild == null)
                if (current == root)
                    root = current.rightChild;
                else if (isLeftChild)
                    parent.leftChild = current.rightChild; // левый потомок родителя
                else
                    parent.rightChild = current.rightChild; // правый потомок родителя
                // два потомка узел заменяется приемником
            else {
                // поиск приемника для удаляемого узла
                Node_v2 successor = getSuccessorRL(current);
                if (current == root)
                    root = successor;
                else if (isLeftChild)
                    parent.leftChild = successor;
                else
                    parent.rightChild = successor;
                successor.leftChild = current.leftChild;
            }
        }
        return true;
    }

    // метод поиска приемника стр. 375, что-то здесь не то..
    public Node_v2 getSuccessorRL(Node_v2 delNode) {
        Node_v2 successorParent = delNode;
        Node_v2 successor = delNode;
        Node_v2 current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild; // так происходит переход к крайнему левому
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    ///////////////////////////////////////////////////////
    // Delete and set NULL ___ My
    // удалить одну ноду и перезалить его child's через root
    public void deleteSingleNodeAndReinsertChild_ByKey(int key) {
        Node_v2 nodeByKey = getNodeByKey(key);
        List<Node_v2> listChildByNode = getListChildByNode(nodeByKey);
        setNodeNullByKey(key);
        for (Node_v2 item : listChildByNode) {
            root.insert(item);
        }
    }

    public List<Node_v2> getListChildByNode(Node_v2 node) {
        List<Node_v2> list = new ArrayList<>();
        if (node.leftChild != null) {
            list.add(node.leftChild);
            List<Node_v2> listLeft = getListChildByNode(node.leftChild);
            list.addAll(listLeft);
        }
        if (node.rightChild != null) {
            list.add(node.rightChild);
            List<Node_v2> listRight = getListChildByNode(node.rightChild);
            list.addAll(listRight);
        }
        return list;
    }

    public void setAllFieldsNullByNode(Node_v2 node) {
        node.leftChild = null;
        node.rightChild = null;
        node.parent = null;
    }

    public boolean setFullNullByNode(Node_v2 node) {
        boolean res1 = true, res2 = true;
        if (node.leftChild != null) {
            res1 = setFullNullByNode(node.leftChild);
        }
        if (node.rightChild != null) {
            res2 = setFullNullByNode(node.rightChild);
        }
        setAllFieldsNullByNode(node);
        return res1 && res2;
    }

    public boolean setFullNullByKey(int key) {
        Node_v2 nodeByKey = getNodeByKey(key);
        boolean res1 = true, res2 = true;
        // если удачно то обнуляем все остальные ветви остоеденного узла
        if (setNodeNullByKey(key)) {
            if (nodeByKey.leftChild != null) {
                res1 = setFullNullByNode(nodeByKey.leftChild);
            }
            if (nodeByKey.rightChild != null) {
                res2 = setFullNullByNode(nodeByKey.rightChild);
            }
        }
        setAllFieldsNullByNode(nodeByKey);
        return res1 && res2;
    }

    public boolean setNodeNullByKey(int key) {
        Node_v2 nodeByKey = getNodeByKey(key);
        Node_v2 parent = nodeByKey.parent;
        if (parent.leftChild != null && parent.leftChild.key == key) {
            parent.leftChild = null;
            return true;
        }
        if (parent.rightChild != null && parent.rightChild.key == key) {
            parent.rightChild = null;
            return true;
        }
        return false;
    }

    //////////////////////////////////////////////////////////
    // Симметричный обход дерева _ начиная с указанной ноды
    public void displayTree(Node_v2 localNode, String leftOrRight) { // показ узлов, начиная от localNode
        if (localNode != null) {
            displayTree(localNode.leftChild, "\u001B[34mleft");
            System.out.println(leftOrRight + ": " + localNode);
            displayTree(localNode.rightChild, "\u001B[30mright");
        }
    }

    public void displayPreOrder(Node_v2 localNode, String leftOrRight) { // показ узлов, начиная от localNode
        if (localNode != null) {
            System.out.println(leftOrRight + ": " + localNode);
            displayTree(localNode.leftChild, "\u001B[34mleft");
            displayTree(localNode.rightChild, "\u001B[30mright");
        }
    }

    public void displayPostOrder(Node_v2 localNode, String leftOrRight) { // показ узлов, начиная от localNode
        if (localNode != null) {
            displayTree(localNode.leftChild, "\u001B[34mleft");
            displayTree(localNode.rightChild, "\u001B[30mright");
            System.out.println(leftOrRight + ": " + localNode);
        }
    }

    public void showAllFields() {
        System.out.println("current key: " + key);
        System.out.println("root: " + root);
        System.out.println("parent: " + parent);
        System.out.println("left: " + leftChild);
        System.out.println("right: " + rightChild);
    }

    @Override
    public String toString() {
        int levelIs = level;
        return String.format("level is: %" + (levelIs + 1) + "d  ", level) +
//                "Node_v2{" + "mainNode=" + mainNode + ", root=" + root + ", leftChild=" + leftChild +
                ", parent value=" + parent.key +
                ", value='" + value + '\''
//                ", rightChild=" + rightChild + ", key=" + key  + ", level='" + level + '\'' + '}'
                ;
    }
}