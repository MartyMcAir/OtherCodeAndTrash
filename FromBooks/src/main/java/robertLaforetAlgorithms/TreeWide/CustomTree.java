package robertLaforetAlgorithms.TreeWide;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    static Entry<String> root;

    Map<String, Boolean> mapVisited = new LinkedHashMap<>();

    public CustomTree(Entry<String> root) {
        this.root = root;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean isCompleteChildes;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
            this.isCompleteChildes = false;
        }

        public boolean isAvailableToAddChildren() {
            // это назвается дизъюнкция _ возвращающий дизъюнкцию полей
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public String getElementName() {
            return elementName;
        }
    }

    // добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName),
    // искать место для вставки начинаем слева направо.
    @Override
    public boolean add(String s) {
        Entry<String> currentEntry = root, last;
        mapVisited.put(root.getElementName(), false);

        Entry<String> newEntry = new Entry<>(s);
        // Заливка элементов слева на право в ширину..
        while (currentEntry != null) {
            // если ветки не было ранее
//            if (!mapVisited.containsKey(currentEntry.getElementName())) {
//                mapVisited.put(currentEntry.getElementName(), true);
//            }
            last = currentEntry;

            // если все вершины заполнены, то добавление начинаем с крайней левой стороны
            if (allVertexIsFull()) {
                currentEntry = currentEntry.leftChild;
                // availableToAddLeftChildren - не проверяем т.к. и так понятно
                newEntry.parent = currentEntry;
                currentEntry.leftChild = newEntry;
                currentEntry.availableToAddLeftChildren = false;
            } else if (currentEntry.isCompleteChildes) { // если вершина не заполнена
                if (currentEntry.availableToAddLeftChildren) {
                    newEntry.parent = currentEntry;
                    currentEntry.leftChild = newEntry;
                    currentEntry.availableToAddLeftChildren = false;
                } else {
                    currentEntry.rightChild = newEntry;
                    currentEntry.availableToAddRightChildren = false;
                    currentEntry.isCompleteChildes = true;
                }
            }

        }

        return true;
    }


    public boolean allVertexIsFull() {
        Entry<String> currentEntry = root, tmp;
        while (currentEntry != null) {
            if (!currentEntry.isCompleteChildes) {
                return false;
            }

            if (currentEntry.leftChild != null) {
                currentEntry = currentEntry.leftChild;
            } else if (currentEntry.rightChild != null) {
                currentEntry = currentEntry.rightChild;
            }
        }
        return true;
    }


    // возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.
    public Entry<String> getParent(String s) {
        return null;
    }

    public void show(){

    }

    // возвращает текущее количество элементов в дереве.
    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    /////////////////////////////////////////
    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
}
