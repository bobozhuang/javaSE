package main.java.com.bobozhuang.exam;

import java.util.Scanner;

/**
 * description： 接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * author Hubery
 * date 2020-05-28
 * version v0.0.1
 * since v0.0.1
 **/
public class ScaleTransform {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(fun(str.substring(2)));
        }
    }

    public static int fun(String s) {
        int n = 0;
        int count = 0;
        int temp = 0;
        char ch;

        while (count < s.length()) {
            ch = s.charAt(s.length() - count - 1);
            if (ch >= '0' && ch <= '9') {
                temp = ch - '0';
            } else if (ch >= 'A' && ch <= 'Z') {
                temp = ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'z') {
                temp = ch - 'a' + 10;
            } else {
                break;
            }
            n += temp * Math.pow(16, count);
            count++;
        }

        return n;
    }
}
