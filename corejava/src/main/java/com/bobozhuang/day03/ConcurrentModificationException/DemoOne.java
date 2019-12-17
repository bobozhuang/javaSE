package main.java.com.bobozhuang.day03.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;

/**
 * description：ArrayList的一个线程安全的变体，其所有可变操作（add、set 等）都是通过对底层数组进行一次新的复制来实现的。
 *                  看看ArrayList对remove的实现
 *
 *                  https://blog.csdn.net/enlangs/article/details/20655255
 * author Hubery
 * date 2019-12-12
 * version v0.0.1
 * since v0.0.1
 **/
public class DemoOne {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            a.add("==> " + String.valueOf(i));
        }

        for (String b : a) {
            System.out.println(b);
            a.remove(0);        //查看源码
        }

    }
}
