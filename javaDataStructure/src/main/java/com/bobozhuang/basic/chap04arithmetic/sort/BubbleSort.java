package main.java.com.bobozhuang.basic.chap04arithmetic.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //bubbleSort(arr);
        bubbleSortPlus(arr);
        //System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                System.out.println(array.length - i - 1);
                if (array[j] > array[j + 1]) {
                    exch(array, j, j + 1);
                }
            }
        }
        return array;
    }

    /**
     * 优化，如果已经排好顺序就结束循环
     * @param array
     * @return
     */
    public static int[] bubbleSortPlus(int[] array) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
//                System.out.println(array.length - i - 1);
                if (array[j] > array[j + 1]) {
                    exch(array, j, j + 1);
                    //num++;//交换次数
                    flag = false;
                }
                num++;
            }
            printer(array);
            if (flag == true){
                break;
            }
        }
        System.out.println("num : " + num);
        return array;
    }
    /**
     * 继续优化，如果结尾已经排好顺序的就不继续进行比较了
     * 比如：6789已经是有序的，就记录6的位置，这个位置往后就不进行比较了
     * array.length - i - 1,这个只是最坏状态下，无序的边界
     * @param array
     * @return
     */
    public static int[] bubbleSortSuper(int[] array) {
        int num = 0;
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted  = true;
            for (int j = 0; j < sortBorder; j++) {
//                System.out.println(array.length - i - 1);
                if (array[j] > array[j + 1]) {
                    exch(array, j, j + 1);
                    //num++;//交换次数
                    isSorted  = false;
                    lastExchangeIndex = j;
                }
                num++;
            }
            printer(array);
            sortBorder = lastExchangeIndex;
            if (isSorted  == true){
                break;
            }
        }
        System.out.println("num : " + num);
        return array;
    }

    private static int[] exch(int[] arr, int i, int j) {//exchange
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    private static void printer(int[] arr) {
        for (int a :
                arr) {
            System.out.print(a);
        }
        System.out.print("\n");
    }
}
