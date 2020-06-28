package stepik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
// https://stepik.org/lesson/12776/step/11?discussion=1768507&unit=3124

public class CollectionTusk {
    // http://stackoverflow.com/questions/3716920/cant-add-value-to-the-java-collection-with-wildcard-generic-type

    // Предположим, у нас есть две переменных:
    //Collection<?> collection = ...;
    //Object object = ...;
    //Какие операции над collection допустимы?

    // не правильные варианты т.к.
    // Вопросительный знак говорит компилятору: коллекция чем-то параметризована, но в данном месте кода мы не знаем,
    // чем именно. Чтобы не дать нам случайно нарушить параметризацию коллекции,
    // т.е. добавить в нее объект неправильного класса, компилятор не разрешает ничего добавлять.
    //collection.addAll(Arrays.asList(object))
    // collection.add(object)

    // collection.clear()
    //collection.remove(object)
    //collection.size()
    //collection.iterator()
    //collection.toArray()
    //collection.contains(object)
    public static void main(String[] args) {
        Collection<?> collection = (Collection<?>) new ArrayList<>();
//        Collection<?> collection = (Collection<?>) new ArrayList<Object>();
        Object object = new Object();
        // А дальше начинаем чекать:
        Iterator<?> iterator = collection.iterator();
//        collection.add("do not work add");
        // collection.addAll(Arrays.asList(object));  // - есть мнение что такое сработает, но нет
        collection.add(null); // а null можно


    }
}