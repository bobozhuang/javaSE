package main.java.com.bobozhuang.morethread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * description：
 * author Hubery
 * date 2020-09-05
 * version v0.0.1
 * since v0.0.1
 **/
public class AtomicIntegerTest4 {

    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(0);
        System.out.println(count);
        //将给定的值原子地添加到当前值。
        int i = count.addAndGet(2);
        System.out.println(i);
        System.out.println(count);
        System.out.println("--------");

        //原子上增加一个当前值。当前值原子+1。
        int i3 = count.incrementAndGet();
        System.out.println(i3);
        System.out.println(count);
        System.out.println("--------");

        //当前值原子减1。
        int i1 = count.decrementAndGet();
        System.out.println(i1);
        System.out.println(count);
        System.out.println("--------");


        //如果当前值 == 为预期值，则将该值原子设置为给定的更新值。
        boolean b = count.compareAndSet(2, 4);
        System.out.println(b);
        System.out.println(count);
        System.out.println("--------");


        //当前值原子减1。  返回原来值
        int andDecrement = count.getAndDecrement();
        System.out.println(andDecrement);
        System.out.println(count);
        System.out.println("--------");

        //原子上增加一个当前值。  返回原来值
        int andIncrement = count.getAndIncrement();
        System.out.println(andIncrement);
        System.out.println(count);
        System.out.println("--------");

        //返回此值 AtomicInteger为 double一个宽元转换后。
        double v = count.doubleValue();
        System.out.println(v);
        System.out.println(count);
        System.out.println("--------");

        //返回此值 AtomicInteger为 float一个宽元转换后。
        float v1 = count.floatValue();
        System.out.println(v1);
        System.out.println(count);
        System.out.println("--------");

        //将给定的值原子地添加到当前值。
        int andAdd = count.getAndAdd(2);
        System.out.println(andAdd);//当前值
        System.out.println(count);//添加后的值
        System.out.println("--------");

        //原子设置为给定值并返回旧值。
        int andSet = count.getAndSet(1);
        System.out.println(andSet);//当前值
        System.out.println(count);//添加后的值
        System.out.println("--------");

        //最终设定为给定值。 方法没有返回值
        count.lazySet(9);
        System.out.println(count);//添加后的值
        System.out.println("--------");

        //设置为给定值。 方法没有返回值
        count.set(8);
        System.out.println(count);//添加后的值
        System.out.println("--------");

        //获取当前值。
        int i2 = count.get();
        System.out.println(i2);
        System.out.println(count);
        System.out.println("--------");

        //如果当前值 ==为预期值，则将值设置为给定更新值。
        boolean b1 = count.weakCompareAndSet(8, 1);
        System.out.println(b1);
        System.out.println(count);//添加后的值
        System.out.println("--------");


    }
}
