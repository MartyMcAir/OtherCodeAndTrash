package SortingAlgoCS50;

public class SelectionSort {
    public static void main(String[] args) {
//        Integer[] arr = MyArr.getArrIntegers(100);
        Integer[] arr = MyArr.getReverseArrIntegers(100);

//        MyArr.arrayShuffle(arr);
        MyArr.printArr(arr);
        System.out.println("\n------------------------------");

        selectionSort(arr);
//        doubleSelectionSort(arr); // не осилил
        MyArr.printArr(arr);
    }

    public static void selectionSort(Integer[] arr) {
        int sortedIndex = 0, current = 0, minValIndex = 0, tmpVar;

        while (arr.length - 1 != sortedIndex) {
            for (int i = sortedIndex; i < arr.length; i++) {
                current = arr[i];

                if (current < arr[minValIndex]) {   // исщем найменьшее
                    minValIndex = i;
                }
            }
            // свапаем найменьшее на место sortedIndex _ а на место найменьшего значение с sortedIndex
            tmpVar = arr[sortedIndex];
            arr[sortedIndex] = arr[minValIndex];
            arr[minValIndex] = tmpVar;

            sortedIndex++;   // переход к след. индексу
        }
    }

    public static void doubleSelectionSort(Integer[] arr) {
        int sortedStartIndex = 0, current = 1, minValIndex = 0, startVar;
        int sortedEndIndex = arr.length - 1, maxValIndex = 0, endVar;

        while (sortedEndIndex != sortedStartIndex) {
            for (int i = sortedStartIndex; i < sortedEndIndex; i++) {
                current = arr[i];

                if (current <= arr[minValIndex])
                    minValIndex = i;
                if (current >= arr[maxValIndex])
                    maxValIndex = i;
            }
            // свапаем найменьшее на место sortedIndex _ а на место найменьшего значение с sortedIndex
            startVar = arr[sortedStartIndex];
            endVar = arr[sortedEndIndex];

            Integer sortedStartValue = arr[sortedStartIndex];
            sortedStartValue = arr[minValIndex];

            Integer sortedEndValue = arr[sortedEndIndex];
            sortedEndValue = arr[maxValIndex];


            arr[minValIndex] = startVar;
            arr[maxValIndex] = endVar;

            sortedStartIndex++;
            sortedEndIndex--;
        }
    }

    /////////////////////////////////////////////////////////////
    // from https://javarush.ru/quests/lectures/questharvardcs50.level03.lecture08
    public static void selectionSortFromJrush1(Integer[] arr) {
        int minElement;
        int sorted = 0, unsorted = arr.length - 2;

        while (sorted < unsorted) {
            minElement = find_min_element(arr, arr.length, sorted + 1);
            if (minElement != sorted)
                swap_int(arr[minElement], arr[sorted]);
            sorted++;
        }
    }

    public static void swap_int(int a, int b) {
        if (a == b)
            return;
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static int find_min_element(Integer[] haystack, int length, int start) {
        int minElement = start;
        while (++start < length) {
            if (haystack[start] < haystack[minElement])
                minElement = start;
        }
        return minElement;
    }

}