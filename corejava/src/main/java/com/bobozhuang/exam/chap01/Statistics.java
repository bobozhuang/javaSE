package main.java.com.bobozhuang.exam.chap01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * description： 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
 * 数据范围小于1e6
 * <p>
 * 这道题有毒，输入不是多行的，而是一行输入，不要被坑了
 * author Hubery
 * date 2020-07-31
 * version v0.0.1
 * since v0.0.1
 **/
public class Statistics {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");       //我这个是通过 空格分割的，读一行就计算
        int negativeNum = 0;
        int positiveNum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if (num < 0) {
                negativeNum++;
            } else {
                sum += num;
                positiveNum++;
            }
        }
        System.out.println(negativeNum);
        System.out.println(Math.round(sum * 10.0 / positiveNum) / 10.0);
    }
}
