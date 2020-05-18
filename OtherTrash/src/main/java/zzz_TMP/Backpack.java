package zzz_TMP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//  (рюкзак), который составляет и перебирает все наборы предметов и выбирает из них самый лучший
//  (его общая масса не больше W, а стоимость среди подходящих по массе наборов – максимальна)
public class Backpack {
    private List<Item> bestItems = null; // общая стоимость предметов лучшего набора
    private double maxW; // максимальная масса рюкзака
    private double bestPrice; // лучший набор предметов для рюкзака
    private final AtomicInteger atomicInteger = new AtomicInteger();

    public Backpack(double maxW) {
        this.maxW = maxW;
    }

    private double calcWeight(List<Item> items) { //  суммарный вес предметов
        double sumW = 0;
        for (int i = 0; i < items.size(); i++) {
            sumW += items.get(i).weight;
        }
        return sumW;
    }

    private double calcPrice(List<Item> items) { // общая стоимость набора предметов
        double sumPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            sumPrice += items.get(i).price;
        }
        return sumPrice;
    }

    public AtomicInteger getAtomicInteger() {  // для подсчета кол-ва рекурсий
        return atomicInteger;
    }

    // геттер для получившегося решения
    public List<Item> getBestItems() {
        return bestItems;
    }

    // сравнивающий текущий лучший набор предметов (список List) в экземпляре класса с набором
    // предметов из аргументов метода. Если набор из аргументов лучше, то он сохраняется в поле класса:
    private void checkSet(List<Item> items) {
        if (bestItems == null) { // если лучшего набора еще не было
            // если вместимость рюкзака меньше или равна, полученным подсчетам
            // из calcWeight(..) всех items
            if (calcWeight(items) <= maxW) {
                bestItems = items; // ставим этот набор-список как лучший
                bestPrice = calcPrice(items); // и ставим его price, полученный из calcPrice(..) всех items
            }
        } else { // иначе в рюкзак не помещается, а значит
            // если общ вес items <= весу рюкзака (его вместимости)
            // и price больше ранее установленного bestPrice
            if (calcWeight(items) <= maxW && calcPrice(items) > bestPrice) {
                bestItems = items; // то ставим этот набор-список как лучший
                bestPrice = calcPrice(items);
            }
        }
    }

    // Главный метод _ что запускает весь процесс и юза всех остльаных методов
    // перебирает все возможные наборы (перестановки) предметов для рюкзака. Данный метод рекурсивный.
    // Сначала в наборе все N предметов, затем, при переходе вглубь на один уровень рекурсии,
    // один предмет удаляется. Выход из рекурсии произойдёт, когда список предметов станет пустым.
    public void makeAllSets(List<Item> items) {
        if (items.size() > 0) { // если полученные список больше 0
            // ПРИ КАЖДОЙ РЕКУРСИИ _ и если там внутри метода checkSet() определится, что
            // текущий список соответствует требования:
            // т.е. calcPrice(..) > bestPrice и calcWeight(..) <= maxW
            // _ то текущ список будет присвоен в =bestItems и его price в =bestPrice
            checkSet(items);  // чекаем список
            // так когда все рекурсии, и их под ветки закончатся останется,
            // только лучшее из возможных, решение _ благодаря фильтру из if ветвлений на каждой интерации

        } // и далее запускаем рекурсию в цикле
        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items); // создаем новый список на базе полученного
            newSet.remove(i); // удаляем у него текущ элемент
            atomicInteger.getAndIncrement();
            makeAllSets(newSet); // отправляем в наш же метод _ рекурсия
            // и каждая рекурсия, создает свою отдельную ветку рекурсий, пока список не закончится
        }
    }
}
