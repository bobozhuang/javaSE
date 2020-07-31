package main.java.com.bobozhuang.threadlocal.LearnOne;

import java.util.Set;

/**
 * description：
 * author Hubery
 * date 2020-05-06
 * version v0.0.1
 * since v0.0.1
 **/
public class DemoOne {

    static ThreadLocal<Integer> c = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {

        add();
        addp();
        for (int i = 0; i < 5; i++) {
            add();
        }
    }

    public static void add(){
        System.out.println(c.get());
        c.set(c.get() + 1);
    }

    public static void addp(){
        System.out.println(c.get());
        c.set(c.get() + 1);
    }
}
