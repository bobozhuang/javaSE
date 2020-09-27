package main.java.com.bobozhuang.collection.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description： ConcurrentLinkedQueue不能阻塞队列，但是速度快。在不需要阻塞的情况下，应该优选ConcurrentLinkedQueue。
 *
 * author Hubery
 * date 2020-08-27
 * version v0.0.1
 * since v0.0.1
 **/
public class NoBlockQueue {

    private static ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Producer("producer1"));
        executorService.submit(new Producer("producer2"));
        executorService.submit(new Producer("producer3"));
        executorService.submit(new Consumer("consumer1"));
//        executorService.submit(new Consumer("consumer2"));
//        executorService.submit(new Consumer("consumer3"));

    }

    static class Producer implements Runnable {
        private String name;

        public Producer(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 1; i < 10; ++i) {
                System.out.println(name+ " start producer " + i);
                concurrentLinkedQueue.add(i);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //System.out.println(name+"end producer " + i);
            }
        }
    }

    static class Consumer implements Runnable {
        private String name;

        public Consumer(String name) {
            this.name = name;
        }
        public void run() {
            for (int i = 1; i < 10; ++i) {
                try {
                    // 这个时非阻塞的，如果没有生产的就结束
                    System.out.println(name+" Consumer " +  concurrentLinkedQueue.poll());

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
//                System.out.println();
//                System.out.println(name+" end Consumer " + i);
            }
        }
    }
}
