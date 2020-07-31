package main.java.com.bobozhuang.exam;

import java.util.Scanner;

/**
 * description：接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * author Hubery
 * date 2020-05-27
 * version v0.0.1
 * since v0.0.1
 **/
public class WorldNum {

    public static int getCount(String str, char c) {
        int count = 0;
        if (str != null && str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (c == str.charAt(i)) {
                    count++;
                }
            }
        } else {
            count = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();      //next每次执行对一次 换行
        char c = s.next().charAt(0);
        int i = getCount(str, c);
        System.out.println(i);
    }

}
