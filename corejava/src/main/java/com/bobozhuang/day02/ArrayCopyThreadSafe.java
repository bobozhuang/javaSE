package main.java.com.bobozhuang.day02;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：     多线程对数组进行复制 (java中System.arraycopy是线程安全的吗？ )
 *
 *                  arrayOriginal 和 arraySrc 初始化时是相同的, 而 arrayDist 是全为零的.
 *
 *                  启动一个线程运行 copy() 方法来拷贝 arraySrc 到 arrayDist 中.
 *
 *                  在主线程执行 modify() 操作, 修改 arraySrc 的内容. 为了确保 copy() 操作先于 modify() 操作, 我使用 Condition, 并且延时了两毫秒, 以此来保证执行拷贝操作(即System.arraycopy) 先于修改操作.
 *
 *                  根据第三点, 如果 System.arraycopy 是线程安全的, 那么先执行拷贝操作, 再执行修改操作时, 不会影响复制结果, 因此 arrayOriginal 必然等于 arrayDist; 而如果 System.arraycopy 是线程不安全的, 那么 arrayOriginal 不等于 arrayDist.
 *
 *                  根据上面的推理, 运行一下程序, 有如下输出:
 * author Hubery
 * date 2020-12-06
 * version v0.0.1
 * since v0.0.1
 **/
public class ArrayCopyThreadSafe{

    public static void main(String[] args) throws Exception {
        doThreadSafeCheck();
    }

    private static int[] arrayOriginal = new int[1024 * 1024 * 10];
    private static int[] arraySrc = new int[1024 * 1024 * 10];
    private static int[] arrayDist = new int[1024 * 1024 * 10];
    private static ReentrantLock lock = new ReentrantLock();

    private static void modify() {
        for (int i = 0; i < arraySrc.length; i++) {
            arraySrc[i] = i + 1;
        }
    }

    private static void copy() {
        System.arraycopy(arraySrc, 0, arrayDist, 0, arraySrc.length);
        System.out.println("copy end ！");
    }

    private static void init() {
        for (int i = 0; i < arraySrc.length; i++) {
            arrayOriginal[i] = i;
            arraySrc[i] = i;
            arrayDist[i] = 0;
        }
    }

    private static void doThreadSafeCheck() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("run count: " + (i + 1));
            init();
            Condition condition = lock.newCondition();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    condition.signalAll();
                    lock.unlock();
                    copy();
                }
            }).start();


            lock.lock();
            // 这里使用 Condition 来保证拷贝线程先已经运行了.
            condition.await();
            lock.unlock();

            Thread.sleep(2); // 休眠2毫秒, 确保拷贝操作已经执行了, 才执行修改操作.
            modify();

            if (!Arrays.equals(arrayOriginal, arrayDist)) {
                throw new RuntimeException("System.arraycopy is not thread safe");
            }
        }
    }

}
