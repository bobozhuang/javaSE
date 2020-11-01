package main.java.com.bobozhuang.morethread.atomic;

/**
 * description：     count++ 操作不是线程安全的
 * author Hubery
 * date 2020-05-08
 * version v0.0.1
 * since v0.0.1
 **/
public class AtomicIntegerTest1 {

    private static final int THREADS_CONUT = 20;
    public static int count = 0;

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
            System.out.println(Thread.activeCount());
        }
        System.out.println(count);

    }


}
