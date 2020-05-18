package z_HanoyaTowers;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TmpMyHanoya {
    Deque<Integer> t1_source = new LinkedList<>();
    Deque<Integer> t2_to = new LinkedList<>();
    Deque<Integer> t3_buffer = new LinkedList<>();
    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
//        jRushTusk();

        TmpMyHanoya han = new TmpMyHanoya();

        // подготовили башню
        han.prepareTowers(han.t1_source, 3);

//        han.hTowers(han.t1_source, han.t3_buffer, han.t2_to);

        han.hTowers2(han.t1_source, han.t3_buffer, han.t2_to);
    }

    public void prepareTowers(Deque<Integer> towerSet, int addAmountOfElements) {
//        // при перестановке будет сниматься найменьший _ потому и очередь
//        for (int i = addAmountOfElements; i >= 1; i--)
        for (int i = 1; i <= addAmountOfElements; i++)
            towerSet.add(i);

//        System.out.println(towerSet); // 1 2 3
//        towerSet.poll();  // сняли найменьший верхний,  т.е. 1
//        System.out.println(towerSet); // [2, 3]

        Integer int1 = 1;
        Integer int2 = 3;
//        System.out.println(int2 > int1);
//        System.out.println(int2.intValue() - int1.intValue());
    }

    public void hTowers2(Deque<Integer> source_1, Deque<Integer> buffer_2, Deque<Integer> toPoint_3) {
        // методом сравнения минимал диска с теми, что уже лежит на других штырях
        // сильно много комбинаций

        if(!source_1.isEmpty() & buffer_2.isEmpty() & toPoint_3.isEmpty()){

        }

        if(!source_1.isEmpty() & !buffer_2.isEmpty() & toPoint_3.isEmpty()){

        }

        if(source_1.isEmpty() & !buffer_2.isEmpty() & !toPoint_3.isEmpty()){

        }

    }
    public void hTowers(Deque<Integer> source_1, Deque<Integer> buffer_2, Deque<Integer> toPoint_3) {
        Optional<Integer> diskAmount = source_1.stream().max(Integer::compareTo);
        // правило нельзя класть более крупные диски на маленькие
//        System.out.println(max.get());   // 3

        // без if ветвлений для проверок
        // 1) интерация
        int poll = getPoll(source_1);  // 1 2 3 -> 2 3   _ 0
        buffer_2.add(poll); // 0 -> 1

        int poll1 = getPoll(source_1); // 2 3 -> 3    _ 1
        toPoint_3.add(poll1); // 0 -> 2

        // 2)
        int poll2 = getPoll(buffer_2); // 1 -> 0    _ 2
        toPoint_3.addFirst(poll2); // 2 - > 1 2

        int poll3 = getPoll(source_1); // 3 -> 0    _ 3
        buffer_2.add(poll3); // 0 -> 3

        // 3)
        int poll4 = getPoll(toPoint_3); // 1 2 -> 2    _ 4
        source_1.add(poll4); // 0 -> 1

        int poll5 = getPoll(source_1); // 2 -> 0    _ 6
        // при add 3 2
        buffer_2.add(poll5); // 3 -> 2 3

        int poll6 = getPoll(toPoint_3); // 1 -> 0    _ 5
        // при add 3 2 1
        buffer_2.add(poll6); // 2 3 -> 1 2 3

        System.out.println(buffer_2); //

//        System.out.println(buffer_2); // почему 3 1 2, а не 1 2 3!?
    }

    private int getPoll(Deque<Integer> source) {
        int poll = 0;
        System.out.println(source + ", interaction number is: " + atomicInteger.getAndIncrement());
        if (!source.isEmpty())
            poll = source.pollFirst().intValue();
        return poll;
    }

    private static void jRushTusk() {
        // from JRUsh
        // char a - имя стержня, на котором в начале находятся все кольца;
        //char b - имя стержня, на который нужно перенести все кольца;
        //char c - имя вспомогательного стержня;
        //int numRings - общее количество колец, которые необходимо перенести.
        //Задачу нужно решать используя рекурсивный вызов метода moveRing.
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    // Метод moveRing вызывается с параметрами: 'A', 'B', 'C', 3
    //Ожидаемый вывод:
    //from A to B
    //from A to C
    //from B to C
    //from A to B
    //from C to A
    //from C to B
    //from A to B
    // на многих сайтах именно этот алгоритм _ но его вывод не совпадает сJRush
    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if (numRings >= 1) {
            moveRing(a, c, b, --numRings);
            printMove(a, b);
            moveRing(c, b, a, --numRings);
        }
    }

    private static void printMove(char a, char b) {
        System.out.println("move disk is: " + a + ", to: " + b);
    }
}
