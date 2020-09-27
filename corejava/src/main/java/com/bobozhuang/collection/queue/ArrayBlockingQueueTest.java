package main.java.com.bobozhuang.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * description：     http://note.youdao.com/s/WywnrXjy
 * author Hubery
 * date 2020-08-27
 * version v0.0.1
 * since v0.0.1
 **/
public class ArrayBlockingQueueTest {

    static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        executorService.submit(new ArrayBlockingQueueTest.Producer("producer1"));
        executorService.submit(new ArrayBlockingQueueTest.Producer("producer2"));
        executorService.submit(new ArrayBlockingQueueTest.Producer("producer3"));
//        executorService.submit(new ArrayBlockingQueueTest.Consumer("consumer1"));
//        executorService.submit(new ArrayBlockingQueueTest.Consumer("consumer2"));
//        executorService.submit(new ArrayBlockingQueueTest.Consumer("consumer3"));
        System.out.println(arrayBlockingQueue.toString());

    }


    static class Producer implements Runnable {
        private String name;

        public Producer(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 1; i < 100; ++i) {
                System.out.println(name+ "  生产： " + i);
                try {
                    boolean add = arrayBlockingQueue.add(i);
                    if (add == false){
                        //该队列的尾部插入指定的元素，超过队列容量的情况下等待指定的等待时间，以使空间在队列已满时变为可用。
                        arrayBlockingQueue.offer(i,100, TimeUnit.SECONDS);
                        //arrayBlockingQueue.offer(i); 不指定相关参数 超过队列容量的情况下 直接返回 false
                        //在该队列的尾部插入指定的元素，如果队列已满，则等待空间变为可用。
                        arrayBlockingQueue.put(i + "p");
                        System.out.println(name+ "  生产： " + i + "p");
                    }

                    //Thread.sleep(200); //模拟慢速的生产，产生阻塞的效果
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

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
                    //检索但不删除此队列的头，如果此队列为空，则返回 null
                    Object peek = arrayBlockingQueue.peek();
                    System.out.println("check  " + peek);
                    //检索并删除此队列的头，如果此队列为空，则直接返回 null 。就是消费不到就结束了
                    Object poll = arrayBlockingQueue.poll();
                    System.out.println(name+" CONSUMMER " +  poll);
                    //还有一个超时的用法，队列空时，指定阻塞时间后返回，不会一直阻塞
                    //但有一个疑问，既然可以不阻塞，为啥还叫阻塞队列？
                    if (arrayBlockingQueue.size()<2){
                        System.out.println(name+" Consumer " +  arrayBlockingQueue.poll(300, TimeUnit.MILLISECONDS));
                    }

                    //必须要使用take()方法在获取的时候阻塞，就是消费不到就等着   检索并删除此队列的头，如有必要，等待元素可用。
                    System.out.println(name+"消费： " +  arrayBlockingQueue.take());
                    //从该队列中删除指定元素的单个实例（如果存在）。
                    arrayBlockingQueue.remove(i + "p");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }


}
