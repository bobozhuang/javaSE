package main.java.com.bobozhuang.iolearn.scanner;

import java.util.Scanner;

/**
 * description：next():一定要读取到有效字符后才可以结束输入。
 *              对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
 *              只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符
 *              不能得到带有空格的字符串。
 * 测试
 * we re we
 * we
 * re
 * we
 * author Hubery
 * date 2020-07-29
 * version v0.0.1
 * since v0.0.1
 **/
public class Next {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.next();
            System.out.println(next);
            //System.out.println(next.length());
        }
    }
}
