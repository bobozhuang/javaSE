package main.java.com.bobozhuang.exam;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;

/**
 * description：
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * <p>
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 输入
 * ABCDEF
 * A
 * 输出
 * 1
 * author Hubery
 * date 2020-05-12
 * version v0.0.1
 * since v0.0.1
 **/
public class exam01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        boolean flag = false;
        int i = 10;
        while (!flag){
            System.out.println(str);

            if (i >0){
                System.out.println(sc.next());

            }else {
                flag = true;
            }
        }


    }



}
