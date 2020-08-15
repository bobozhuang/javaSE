package main.java.com.bobozhuang.iolearn.scanner;

import java.util.Scanner;

/**
 * description： 先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取
 *                  nextLine()以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
 *                  可以获取空格。
 * author Hubery
 * date 2020-07-29
 * version v0.0.1
 * since v0.0.1
 **/
public class OneLine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.nextLine();
            System.out.println(next);
        }
    }

}
