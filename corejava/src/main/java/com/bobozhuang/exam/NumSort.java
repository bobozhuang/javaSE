package main.java.com.bobozhuang.exam;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * description：生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，
 *      然后再把这些数从小到大排序，按照排好的顺序返回。请你协助完成“去重”与“排序”的工作
 *      1、输入随机数的个数n
 *      2、n个随机整数
 *      3、输出处理后的随机整数
 *
 *      分析：这个问题主要是在输入的时候怎么交互
 *
 * author Hubery
 * date 2020-05-27
 * version v0.0.1
 * since v0.0.1
 **/
public class NumSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){        //判断是否还有输入

            int num = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i = 0 ; i < num ;i++){
                int curr = sc.nextInt();
                set.add(curr);
            }
            for(Integer i : set){
                System.out.println(i);
            }
        }

    }


}
