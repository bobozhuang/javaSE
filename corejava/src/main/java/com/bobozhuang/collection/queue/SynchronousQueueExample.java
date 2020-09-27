package main.java.com.bobozhuang.collection.queue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * description： SynchronousQueue是一个内部只能包含一个元素的队列。插入元素到队列的线程被阻塞，直到另一个线程从队列中获取了
 *          队列中存储的元素。同样，如果线程尝试获取元素并且当前不存在任何元素，则该线程将被阻塞，直到线程将元素插入队列。
 *
 * author Hubery
 * date 2020-09-01
 * version v0.0.1
 * since v0.0.1
 **/
public class SynchronousQueueExample {

    public static void main(String[] args) {

        final BlockingQueue<String> synchronousQueue = new SynchronousQueue<String>();

        SynchronousQueueProducer queueProducer = new SynchronousQueueProducer(
                synchronousQueue);
        Thread thread1 = new Thread(queueProducer);
        thread1.setName("producer1");
        thread1.start();

        SynchronousQueueConsumer queueConsumer1 = new SynchronousQueueConsumer(
                synchronousQueue);
        Thread threada = new Thread(queueConsumer1);
        threada.setName("consumer1");
        threada.start();

//        SynchronousQueueConsumer queueConsumer2 = new SynchronousQueueConsumer(
//                synchronousQueue);
//        Thread threadb = new Thread(queueConsumer2);
//        threadb.setName("consumer2");
//        threadb.start();

    }

    static class SynchronousQueueProducer implements Runnable {

        protected BlockingQueue<String> blockingQueue;
        final Random random = new Random();

        public SynchronousQueueProducer(BlockingQueue<String> queue) {
            this.blockingQueue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("--------------- start Product ---------------");
                    String data = UUID.randomUUID().toString();
                    System.out.println(Thread.currentThread().getName()
                            + " Put: " + data);
                    blockingQueue.put(data);
                    Thread.sleep(3000);
                    System.out.println("--------------- finish Product ---------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class SynchronousQueueConsumer implements Runnable {

        protected BlockingQueue<String> blockingQueue;

        public SynchronousQueueConsumer(BlockingQueue<String> queue) {
            this.blockingQueue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("--------------- start Consumer ---------------");
                    String data = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()
                            + " take(): " + data);
//                    Thread.sleep(3000);
                    System.out.println("--------------- finish Consumer ---------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
