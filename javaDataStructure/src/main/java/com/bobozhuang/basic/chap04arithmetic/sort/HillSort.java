package main.java.com.bobozhuang.basic.chap04arithmetic.sort;

public class HillSort {


    public static void Shell(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
//计算步长,1,4,13.....
//循环进行插入排序
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j > h && less(arr[j], arr[j - h]); j -= h) {
                    exch(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static int[] exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    private static boolean less(int first, int second) {
        if (first < second) {
            return true;
        } else {
            return false;
        }
    }
}
