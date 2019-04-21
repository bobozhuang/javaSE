package main.java.com.bobozhuang.basic.chap04arithmetic.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertSort(arr);
        //System.out.println(Arrays.toString(arr));
    }

    /**
     * 将第一个元素当成已经排好序的数组arr，其余的元素X逐个与arr的最后（也是最大）元素Y比较,如果X小就将Y放在X的位置，继续
     * 与arr的下一个元素比较，直到Y大于arr中的元素，然后Y就放在小于arr元素的位置；
     * 如果X最大，就成为arr最大的元素
     * 就这种方式逐个与arr元素比较
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int i, j;
        int n = arr.length;//9
        int target;
        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 到 n-1 次
        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];
            while (j > 0 && arr[j - 1] > target) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
            printer(arr);
        }
    }

    /**
     * 897654321
     * 789654321
     * 678954321
     * 567894321
     * 456789321
     * 345678921
     * 234567891
     * 123456789
     * @param arr
     */
    private static void printer(int[] arr){
        for (int a :
                arr) {
            System.out.print(a);
        }
        System.out.println();
    }
}
