package main.java.com.bobozhuang.day03.ConcurrentModificationException;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * description：
 *      明显可以看出来CopyOnWriteArrayList的执行效率没有ArrayList的效率高，如果明确需要对一个List进行修改，那么CopyOnWriteArrayList是一个好的选择。
 *
 *      如果对List没有修改的需求，建议使用ArrayList。
 *
 * author Hubery
 * date 2019-12-16
 * version v0.0.1
 * since v0.0.1
 **/
public class DemoTwo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10; i++) {
            a.add("==> " + String.valueOf(i));
        }

        for (String b : a) {
            System.out.println(b);
            a.remove(0);            //CopyOnWriteArrayList对remove的实现
        }

        System.out.println(a.size());

    }
}
