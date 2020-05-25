package main.java.com.bobozhuang.morethread.atomic;

/**
 * description：volatile修饰count变量,以下并不能得出"基于volatile变量的运算在并发下是安全的"这个结论，
 *      因为java里的运算（比如自增）并不是原子性的。
 * author Hubery
 * date 2020-05-08
 * version v0.0.1
 * since v0.0.1
 **/
public class AtomicIntegerTest2 {

    private static final int THREADS_CONUT = 20;
    public static volatile int count = 0;

    public static void increase() {
        count++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(count);
    }



}
