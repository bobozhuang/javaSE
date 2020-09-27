package main.java.com.bobozhuang.collection.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * description：一个基于链接节点的无界线程安全队列。此队列按照 FIFO（先进先出）原则对元素进行排序。队列的头部
 *      是队列中时间最长的元素。队列的尾部 是队列中时间最短的元素。
 *      新的元素插入到队列的尾部，队列获取操作从队列头部获得元素。当多个线程共享访问一个公共 collection 时，
 *      ConcurrentLinkedQueue 是一个恰当的选择。此队列不允许使用 null 元素
 *
 * author Hubery
 * date 2020-09-15
 * version v0.0.1
 * since v0.0.1
 **/
public class ConcurrentLinkedQueueTest1 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.offer("哈哈哈"); //将指定元素插入此队列的尾部
        System.out.println("offer后，队列是否空？" + queue.isEmpty());
        System.out.println("从队列中poll：" + queue.poll()); // 获取并移除此队列的头，如果此队列为空，则返回 null。
        System.out.println("pool后，队列是否空？" + queue.isEmpty());
        System.out.println("---------------------");

        // 从队列中移除指定元素的单个实例（如果存在）
        queue.offer("嘿嘿嘿");
        System.out.println("offer后，队列是否空？" + queue.isEmpty());
        //获取但不移除此队列的头；如果此队列为空，则返回 null
        System.out.println("从队列中peek：" + queue.peek());
        System.out.println("从队列中pool：" + queue.poll());
        System.out.println("从队列中peek：" + queue.peek());
        System.out.println("pool后，队列是否空？" + queue.isEmpty());
        System.out.println("---------------------");

        // 从队列中移除指定元素的单个实例（如果存在会返回true，remove不存在元素，返回false）
        queue.offer("AAA");
        queue.offer("BBB");
        queue.offer("CCC");
        System.out.println("offer后，队列是否空？" + queue.isEmpty());
        System.out.println("从队列中remove已存在元素 ：" + queue.remove("BBB"));
        System.out.println("从队列中remove不存在元素：" + queue.remove("123"));
        System.out.println("remove后，队列是否空？" + queue.isEmpty());

    }

}
