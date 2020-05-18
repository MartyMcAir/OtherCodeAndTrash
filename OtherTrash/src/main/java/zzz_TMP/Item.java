package zzz_TMP;

import java.util.ArrayList;
import java.util.List;

public class Item { // сущность “Предмет”. Он содержит три поля: название, вес и стоимость.
    public String name; // имя
    public double weight; // вес объем
    public double price;

    public static void main(String[] args) {
        List<Item> itemsList = new ArrayList<>();
        // заполняем список предметами разный вес-объем и ценность
        itemsList.add(new Item("Apteka", 4, 1500));
        itemsList.add(new Item("LapTop", 2, 40000));
        itemsList.add(new Item("Cat", 1, 500));
        itemsList.add(new Item("Book", 1, 600));
        itemsList.add(new Item("Looser", 2, 5000));
        System.out.println("факториал текущего списка: " + factorial(itemsList.size())); // 120

        Backpack backpack = new Backpack(6); // вес-макси-объем рюкзака 6
        backpack.makeAllSets(itemsList); // кидаем список для перебора рюкзаком
        List<Item> solve = backpack.getBestItems(); // получаем решение
        if (solve == null) {
            System.out.println("Нет Решения");
        } else { // [name='Book, name='Looser, name='LapTop, name='Cat]
            System.out.println(solve); // выводим в консоль названия предметов
            System.out.println("рекурсивных запусков: " + backpack.getAtomicInteger()); // 325
        }
    }

    public static int factorial(int n) {
        int ret = 1;
        for (int i = 1; i <= n; ++i) ret *= i;
        return ret;
    }

    public Item(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name='" + name;
    }
}
