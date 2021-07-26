package main.java.com.bobozhuang.morethread.productconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * description：     BlockingQueue实现
 * author Hubery
 * date 2020-12-10
 * version v0.0.1
 * since v0.0.1
 **/
public class PCDemo3 {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(20);
        Product3 producer1 = new Product3("生产1号", queue);
        Product3 producer2 = new Product3("生产2号", queue);
        Product3 producer3 = new Product3("生产3号", queue);

        Consumer3 consumer1 = new Consumer3("消费1号", queue);
        Consumer3 consumer2 = new Consumer3("消费2号", queue);

        // 开始producer线程进行生产
        new Thread(producer1).start();
        //new Thread(producer2).start();
        //new Thread(producer3).start();

        // 开始consumer线程进行消费。
        new Thread(consumer1).start();
        //new Thread(consumer2).start();
    }

}


class Product3 implements Runnable {
    private BlockingQueue queue;
    private String name;
    private int num = 1;

    public Product3(String name, BlockingQueue queue) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put(num);
                System.out.println(name + "生产：" + num + ".当前队列长度：" + queue.size());
                num++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer3 implements Runnable {
    private BlockingQueue queue;
    private String name;

    public Consumer3(String name, BlockingQueue queue) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int val = (int) queue.take();
                System.out.println(name + "消费：" + val + ".当前队列长度：" + queue.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}