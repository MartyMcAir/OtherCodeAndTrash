package robertLaforetAlgorithms.TreeWide;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* 
Построй дерево(1)
*/
public class CustomTreeMy2 {
    static Entry<String> root, lastCurrent, tmp;
    int sizeCounter = 0;
    Entry<String> next;

    // сохраняем в список родителей, и при след добавлении _ проверка на то пуста ли очередь Parents
    Queue<Entry> parentsQueue1 = new LinkedList<>();
    Queue<Entry> parentsQueue2 = new LinkedList<>();
    boolean flag = true;

    Map<String, Boolean> mapVisited = new LinkedHashMap<>();

    public CustomTreeMy2() {
    }

    public CustomTreeMy2(Entry<String> root) {
        this.root = root;
    }

    // добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName),
    // искать место для вставки начинаем слева направо.
    public boolean add(String s) {
        sizeCounter++;
        lastCurrent = lastCurrent != null ? lastCurrent : root;
        Entry<String> newEntry = new Entry<>(s);
        newEntry.parent = lastCurrent;

        if (flag) {
            parentsQueue1.add(newEntry); // при след добавлении, он будет parent
            setNewEntry(newEntry);

            if (!parentsQueue2.isEmpty() & lastCurrent == null) { // если очередь не пуста
                lastCurrent = parentsQueue2.poll();
            }
            if (parentsQueue2.isEmpty() & lastCurrent == null) {
                flag = false;
                lastCurrent = parentsQueue1.poll();
            }
            return true;
        }

        if (!flag) {
            parentsQueue2.add(newEntry);
            setNewEntry(newEntry);

            if (!parentsQueue1.isEmpty() & lastCurrent == null) { // если очередь не пуста
                lastCurrent = parentsQueue1.poll();
            } else if (parentsQueue1.isEmpty() & lastCurrent == null) {
                flag = true;
                lastCurrent = parentsQueue2.poll();
            }
            return true;
        }
        return false;
    }

    private void setNewEntry(Entry<String> newEntry) {
        if (lastCurrent.availableToAddLeftChildren) {
            lastCurrent.leftChild = newEntry;
            lastCurrent.availableToAddLeftChildren = false;
        } else if (lastCurrent.availableToAddRightChildren) {
            lastCurrent.rightChild = newEntry;
            lastCurrent.availableToAddRightChildren = false;
            lastCurrent.isCompleteChildes = true;
            lastCurrent = null;
        }
    }

    public Entry<String> getLeft() {
        Entry<String> current = root, last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }
// не работает как должно..
    private Entry<String> getParentByRecursive(Entry<String> stringEntry, String find) {
        Entry<String> res = null;
        if (stringEntry != null) {
            boolean equals = stringEntry.getElementName().equals(find);
            if (equals) {
                res = stringEntry.parent;
            } else {
                getParentByRecursive(stringEntry.leftChild, find);
                getParentByRecursive(stringEntry.rightChild, find);
            }
        }
        return res; // если не найдено
    }


    public boolean allVertexIsFull(Entry<String> entry) {
        if (entry.isCompleteChildes) {
            allVertexIsFull(entry.parent.leftChild);
            allVertexIsFull(entry.parent.rightChild);
        }

        return true; // true если у всех вершин есть лев и правые child's
    }

    public boolean add_V1(String s) {
        sizeCounter++;

        Entry<String> currentEntry = lastCurrent != null ? lastCurrent : root;
        Entry<String> newEntry = new Entry<>(s);
//        mapVisited.put(root.getElementName(), false);

        if (!allVertexIsFull(root)) { // если не всевершины with child's
            newEntry.parent = currentEntry;
            if (currentEntry.availableToAddLeftChildren) {
                currentEntry.leftChild = newEntry;
                currentEntry.availableToAddLeftChildren = false;
            } else if (currentEntry.availableToAddRightChildren) {
                currentEntry.rightChild = newEntry;
                currentEntry.availableToAddRightChildren = false;
                currentEntry.isCompleteChildes = true;
            }
            lastCurrent = newEntry.parent;
            return true;
        } else { // ищем сам перв лев элемент
            Entry<String> left = getLeft();
            currentEntry = left;
            newEntry.parent = currentEntry;
            newEntry.parent = currentEntry;
            currentEntry.leftChild = newEntry;
            currentEntry.availableToAddLeftChildren = false;
            lastCurrent = newEntry.parent;
            return true;
        }

//        return false;
    }

    public boolean allVertexIsFull_V1() {
        Entry<String> currentEntry = root, tmp;
        while (currentEntry != null) { //
            // если найдена незаполненная вершина без childes, то false
            if (!currentEntry.isCompleteChildes) {
                return false;
            }

//            System.out.println(currentEntry.elementName);
            // проверка в двойную глубь, т.к. при проверке в 1 лвл
            // при след интерации это выкинет false
            if (currentEntry.leftChild.leftChild != null) {
                currentEntry = currentEntry.leftChild;
            } else if (currentEntry.rightChild.rightChild != null) {
                currentEntry = currentEntry.rightChild;
            } else {
                break;
            }
        }
        return true; // true если у всех вершин есть лев и правые child's
    }

    public void displayTree(Entry<String> entry, String leftOrRight) {
        if (entry != null) {
            System.out.println(leftOrRight + entry);
            displayTree(entry.leftChild, "left: ");
            displayTree(entry.rightChild, "right: ");
        }
    }
}
