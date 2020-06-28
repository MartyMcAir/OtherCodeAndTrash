package SortingAlgoCS50;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] arrIntegers = MyArr.getArrIntegers(100);
        MyArr.arrayShuffle(arrIntegers);
        MyArr.printArr(arrIntegers);
        System.out.println("\n--------------------------------------");


    }

    public static void insertionSort(Integer[] arr) {

    }

    ////////////////////////////////
    // From https://javarush.ru/quests/lectures/questharvardcs50.level03.lecture10
    public static void sortArr(int array[], int n) {
        int temp;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                // swaping.
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    public static void insertion_sort(int haystack[], int length) {
        int sorted = 1, unsorted = length, j;

        while (sorted < unsorted) {
            int tmp = haystack[sorted];
            j = sorted;

            if (haystack[sorted] < haystack[sorted - 1]) {

                do {
                    haystack[j] = haystack[j - 1];
                } while (--j > 0 && tmp < haystack[j - 1]);
                haystack[j] = tmp;
            }
            sorted++;
        }
    }
}
