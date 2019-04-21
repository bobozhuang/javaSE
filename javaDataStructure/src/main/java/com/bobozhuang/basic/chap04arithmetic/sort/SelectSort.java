package main.java.com.bobozhuang.basic.chap04arithmetic.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] ints = {1, 2, 3, 4, 9, 8, 7, 6, 5};
//        selectSort(arr);
        selectSortPlus(arr);
//        selectionSort(arr);

        //printer(arr);
    }

    /**
     * 将下标 1、2对比，下一次小for循环 2、3对比，每次如果小于就会交换位置，小for循环执行完只有9换到了最后的位置
     * 大for循环控制下一次循环开始
     */
    public static void selectSort(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    //System.out.println("ok" + (j-1) + "==" + j);
                    exch(arr, j, j - 1);
                    num++;//交换次数
                }
                //num++;//比较次数
            }
            printer(arr);
        }
        //printer(arr);
        System.out.println("num : " + num );
    }

    public static void selectSortPlus(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            int k = i;// 找出最小值的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    //System.out.println("No" + k + "==" + j);
                    k = j;
                }
            }// 将最小值放到未排序记录的第一个位置
            if (k > i) {
                exch(arr, i, k);
                //num++;//交换次数
            }
            num++;
            printer(arr);
        }
        System.out.println("num : " + num
        );
    }

    /**
     * 将下标 1、2对比，下一次小for循环 2、3对比，每次如果小于只会几下位置，小for循环执行完只有9换到了最后的位置，相比较
     * 之前最优要少交换8次，大for循环控制下一次循环开始
     *
     * @param a
     */
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int k = i;// 找出最小值的下标
            for (int j = i + 1; j < n; j++) {
                if (a[k] > a[j]) {
                    k = j;
                }
            }// 将最小值放到未排序记录的第一个位置
            if (k > i) {
                System.out.println("ok");
                exch(a, i, k);
            }
            printer(a);
        }
    }

    /**
     * 通过数组下标交换数组元素位置
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private static int[] exch(int[] arr, int i, int j) {//exchange
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    /**
     * 将数组内容打印到控制台
     *
     * @param arr
     */
    private static void printer(int[] arr) {
//        System.out.println(Arrays.toString(arr));
        for (int a :
                arr) {
            System.out.print(a);
        }
        System.out.print("\n");
    }
}
