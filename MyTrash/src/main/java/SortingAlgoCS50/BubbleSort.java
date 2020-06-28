package SortingAlgoCS50;

public class BubbleSort {
    public static void main(String[] args) {
        Integer[] arr = MyArr.getArrIntegers(100);
//        Integer[] arr = MyArr.getReverseArrIntegers(100);

        MyArr.arrayShuffle(arr);
        MyArr.printArr(arr);
        System.out.println("\n-------------------------");

        arrayBubbleSort(arr);
        MyArr.printArr(arr);
    }

    public static void arrayBubbleSort(Integer[] arr) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0, j = 1, tmp = 0; i < arr.length - 1; i++, j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }

        }
    }
}
