package main.java.com.bobozhuang.basic.chap04arithmetic.sort;

import java.util.Arrays;

/**
 * 没有搞明白
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 用分治法递归数列的两部分
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    //partition:划分，分开；[数] 分割；隔墙；隔离物
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 坑的位置，初始等于pivot的位置
        int index = startIndex;
        //大循环在左右指针重合或者交错时结束
        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            //left指针从左向右进行比较
            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;//pivot:枢轴；中心点；旋转运动
        return index;
    }
    public static void bubbleSortSuper(int[] arr){
        int lastExchIndex=0;
        int sortBorder = arr.length-1;
        for (int i = 0;i<arr.length;i++){
            boolean isSorted = true;
            for (int j = 0;j< sortBorder;j++){
                if (arr[j] > arr[j+1]){
                    exch(arr,j,j+1);
                    isSorted = false;
                    lastExchIndex = j;
                }
            }
            sortBorder = lastExchIndex;
            if (isSorted == true){
                break;
            }
        }


    }
    public static void exch(int[] arr ,int i ,int j ){
        int temp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = temp;

    }
}



















