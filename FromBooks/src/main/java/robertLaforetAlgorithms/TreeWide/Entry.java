package robertLaforetAlgorithms.TreeWide;

import java.io.Serializable;

public class Entry<String> implements Serializable {
    String elementName;
    boolean isCompleteChildes;
    boolean availableToAddLeftChildren, availableToAddRightChildren;
    Entry<String> parent, leftChild, rightChild;

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


    // возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.
    public Entry<String> getParent(String s) {
        return parent;
    }

    @Override
    public java.lang.String toString() {
        String elementName = parent != null ? parent.getElementName() : (String) "null";
        return "Entry{" +
                "elementName= " + this.elementName +
                ", isCompleteChildes= " + isCompleteChildes +
                ", parent= " + elementName +
//                ", leftChild=" + leftChild +
//                ", rightChild=" + rightChild +
                '}';
    }
}