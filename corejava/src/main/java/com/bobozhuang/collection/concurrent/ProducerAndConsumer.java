package main.java.com.bobozhuang.collection.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *      description：AtomicInteger的getAndIncrment和getAndDcrement()等方法，这些方法分为两步，
 *      get和increment(decrement)，在get和increment中间可能有其他线程进入，导致多个线程get到的数值是相同的，
 *      也会导致多个线程累加后的值其实累加1.在这种情况下，使用volatile也是没有效果的，因为get之后没有对值进行修改，
 *      不能触发volatile的效果。
 *
 * author Hubery
 * date 2020-08-25
 * version v0.0.1
 * since v0.0.1
 **/
public class ProducerAndConsumer {
    public static void main(String[] args) {

        try {
            BlockingQueue queue = new LinkedBlockingQueue(5);

            ExecutorService executor = Executors.newFixedThreadPool(5);
            Produer producer = new Produer(queue);
            for (int i = 0; i < 3; i++) {
                executor.execute(producer);
            }
            executor.execute(new Consumer(queue));

            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Produer implements Runnable {

    private BlockingQueue queue;
    private int nums = 20;  //循环次数

    //标记数据编号
    private static volatile AtomicInteger count = new AtomicInteger();
    private boolean isRunning = true;

    public Produer() {
    }

    public Produer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        String data = null;
        try {
            System.out.println("开始生产数据");
            System.out.println("-----------------------");

            while (nums > 0) {
                nums--;
                count.decrementAndGet();
                Thread.sleep(500);
                queue.put(count.getAndIncrement());
                System.out.println(Thread.currentThread().getId() + " :生产者生产了一个数据: " + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("生产者线程退出！");
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue queue;
    private int nums = 20;
    private boolean isRunning = true;

    public Consumer() {
    }

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {

        System.out.println("消费者开始消费");
        System.out.println("-------------------------");

        while (nums > 0) {
            nums--;
            try {
                while (isRunning) {
                    int data = (Integer) queue.take();
                    Thread.sleep(500);
                    System.out.println("消费者消费的数据是" + data);
                }

            } catch (Exception e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("消费者线程退出!");
            }

        }
    }
}