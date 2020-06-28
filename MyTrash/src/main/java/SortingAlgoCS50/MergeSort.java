package SortingAlgoCS50;

import java.util.Arrays;

// https://stepik.org/lesson/12762/step/9?unit=3110
// & CS50
public class MergeSort {
    public static void main(String[] args) {
        Integer[] reverseArrIntegers = MyArr.getReverseArrIntegers(10);
        MyArr.printArr(reverseArrIntegers);
        System.out.println("\n-----------------------------------------");

        mergeSort(reverseArrIntegers);
        MyArr.printArr(reverseArrIntegers);
    }

    ///////////
    // STEPIK EXAMPLES
    // my _ easy for read
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] newArr = new int[a1.length + a2.length];

        for (int i = 0, j = 0; i < a1.length + a2.length; i++) {
            if (i < a1.length) {
                newArr[i] = a1[i];
            } else {
                newArr[i] = a2[j];
                j++;
            }
        }
        Arrays.sort(newArr);
        return newArr;
    }


    // from форумы решений
    // https://stepik.org/lesson/12762/step/9?thread=solutions&unit=3110
    public static int[] mergeArrays2(int[] a1, int[] a2) {
        int[] a12 = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, a12, 0, a1.length);
        System.arraycopy(a2, 0, a12, a1.length, a2.length);
        Arrays.parallelSort(a12);
        return a12; // your implementation here
    }

    public static int[] mergeArrays3(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
            count++;
        }
        for (int j = 0; j < b.length; j++) {
            c[count++] = b[j];
        }
        Arrays.sort(c);
        return c;
    }

    public static int[] mergeArrays4(int[] a1, int[] a2) {
        if (a1.length == 0) return a2;
        if (a2.length == 0) return a1;
        int[] result = new int[a1.length + a2.length];
        for (int i = 0, a1_i = 0, a2_i = 0; i < result.length; i++) {
            result[i] = a1[a1_i] < a2[a2_i] ? a1[a1_i++] : a2[a2_i++];
            if (a1_i == a1.length) {
                System.arraycopy(a2, a2_i, result, ++i, a2.length - a2_i);
                break;
            }
            if (a2_i == a2.length) {
                System.arraycopy(a1, a1_i, result, ++i, a1.length - a1_i);
                break;
            }
        }
        return result;
    }

    public static int[] mergeArrays5(int[] a1, int[] a2) {
        int i = a1.length, j = a2.length;
        int[] r = new int[(i--) + (j--)];
        while (i >= 0 && j >= 0) r[i + j + 1] = a1[i] > a2[j] ? a1[i--] : a2[j--];
        while (i >= 0) r[i] = a1[i--];
        while (j >= 0) r[j] = a2[j--];
        return r;
    }

    public static int[] mergeArrays6(int[] a1, int[] a2) {
        int size = a1.length + a2.length;
        int[] result = new int[size];

        for (int i = 0, j = 0, k = 0; k < size; ++k) {
            int value = 0;
            if (i < a1.length && j < a2.length) {
                value = (a1[i] < a2[j] ? a1[i++] : a2[j++]);
            } else if (i < a1.length && j >= a2.length) {
                value = a1[i++];
            } else {
                value = a2[j++];
            }
            result[k] = value;
        }
        return result;
    }

    public static int[] mergeArrays7(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];

        int a = 0;
        int b = 0;
        int x = 0;
        while (a < a1.length && b < a2.length){
            if (a1[a] < a2[b]){
                a3[x++] = a1[a++];
            }else {
                a3[x++] = a2[b++];
            }
        }
        while (a < a1.length){
            a3[x++] = a1[a++];
        }
        while (b < a2.length){
            a3[x++] = a2[b++];
        }

        return a3; // your implementation here
    }

    ///////////////////
    public static void mergeSort(Integer[] arr) {
        if (arr.length < 2) return;

        int halfLength = arr.length / 2;
        // сортируем левую половину _ рекурсивно
        sortLeftStartArr(arr, halfLength);
        // сортируем правую половину _ рекурсивно
        sortRightEndArr(arr, arr.length - halfLength);

        // слияние левой и правой с пошаговым сравнением чисел сначала одно слева потом одно справа и т.д.
    }

    private static void sortLeftStartArr(Integer[] arr, int halfLength) {

        for (int i = 0; i < arr.length; i++) {

        }
    }

    private static void sortRightEndArr(Integer[] arr, int i) {
    }


    // 4 3 2 1
//    private static void sortLeftStartArr(Integer[] arr, int halfLength) {
//        int hulfAff = arr.length / 2;
//        Integer[] arrLeftStart = new Integer[hulfAff];
//        Integer[] arrRightEnd = new Integer[arr.length - hulfAff];
//
//        if (hulfAff < 2) return;   // если меньше двух элементво не делим
//
//        sortLeftStartArr(arrLeftStart, arrLeftStart.length);
//        sortRightEndArr(arrRightEnd, arrRightEnd.length);
//
//        if (hulfAff == 2) {
//            for (int i = 0; i < hulfAff; i++) {
//
//            }
//        }
//    }
//
//    private static void sortRightEndArr(Integer[] arr, int halfLength) {
//        int hulfAff = arr.length / 2;
//        Integer[] arrLeftStart = new Integer[hulfAff];
//        Integer[] arrRightEnd = new Integer[arr.length - hulfAff];
//
//        if (hulfAff < 2) return;   // если меньше двух элементво не делим
//
//        sortLeftStartArr(arrLeftStart, arrLeftStart.length);
//        sortRightEndArr(arrRightEnd, arrRightEnd.length);
//    }

    // and here https://javarush.ru/groups/posts/2202-sortirovka-slijaniem-merge-sort
    ////////////////////////
    // From https://javarush.ru/quests/lectures/questharvardcs50.level03.lecture11
    public static void Sort(int a[], int first, int last) {
        if (first < last) {
            Sort(a, first, (first + last) / 2); //делим левую часть
            Sort(a, (first + last) / 2 + 1, last); //делим правую часть
            Merge(a, first, last); //собираем то, что получилось в функции объединения (см. ниже)
        }
    }

    public static void Merge(int a[], int first, int last) {
        int middle, left, right, j; //по очереди: номер среднего элемента; начало левой половины; начало второй; счетчик
        int[] temp = new int[last + 1];
        middle = (first + last) / 2;
        left = first;
        right = middle + 1;
        for (j = first; j <= last; j++) {
//Далее определяем какой из элементов меньше, записываем в временный массив и смещаем счетчик на следующий элемент
//Также учтены ситуации, когда в половинах заканчиваются элементы: в таком случае меньшим окажется элемент из соседней половины
            if ((left <= middle) && ((right > last) || (a[left] < a[right]))) {
                temp[j] = a[left];
                left++;
            } else {
                temp[j] = a[right];
                right++;
            }
        }
        for (j = first; j <= last; j++) {
            a[j] = temp[j];
        }
    }


}
