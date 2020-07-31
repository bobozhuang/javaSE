package main.java.com.bobozhuang.iolearn.scanner;

import java.util.Scanner;

/**
 * description：
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
        }
    }
}
