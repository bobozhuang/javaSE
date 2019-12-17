package main.java.com.bobozhuang.day03.chap06;

import java.util.ArrayList;
import java.util.List;

/**
 * description£º
 * author Hubery
 * date 2019-12-10
 * version v0.0.1
 * since v0.0.1
 **/
public class IntegerTest {
    public static void main(String[] args) {
        String str = "abcedfºÃ";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            System.out.println("c: " + c);
            String s = Integer.toString(c, 10);
            System.out.println("s: " + s);

        }

        ArrayList<Object> arrayList = new ArrayList<>();
    }
}
