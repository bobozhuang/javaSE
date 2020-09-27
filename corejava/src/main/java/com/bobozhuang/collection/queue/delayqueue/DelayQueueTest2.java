package main.java.com.bobozhuang.collection.queue.delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * description： DelayQueue 是一个无界阻塞队列，要添加进去的元素必须实现Delayed接口，只有在延迟期满时才能从中提取元素。
 *              该队列的头部 是延迟期满后保存时间最长的 Delayed 元素。
 *              如果延迟都还没有期满，则队列没有头部，并且 poll 将返回 null。
 *              当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于等于 0 的值时，表示该元素到期了。
 *              无法使用 take 或 poll 移除未到期的元素，也不会将这些元素作为正常元素对待。例如，size 方法同时返回到期和未到期元素的计数。
 *              此队列不允许使用 null 元素。
 *https://blog.csdn.net/toocruel/article/details/82769595?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522160024395019724835858688%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=160024395019724835858688&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-3-82769595.first_rank_ecpm_v3_pc_rank_v2&utm_term=DelayQueue&spm=1018.2118.3001.4187
 *              DelayQueue只能添加(offer/put/add)实现了Delayed接口的对象，意思是说我们不能想往DelayQueue里添加什么就添加什么，
 *              不能添加int、也不能添加String进去，必须添加我们自己的实现了Delayed接口的类的对象
 * author Hubery
 * date 2020-09-17
 * version v0.0.1
 * since v0.0.1
 **/
public class DelayQueueTest2 {
    private static DelayQueue delayQueue = new DelayQueue();

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {

                delayQueue.offer(new MyDelayedTask("task1", 10000));
                delayQueue.offer(new MyDelayedTask("task2", 3900));
                delayQueue.offer(new MyDelayedTask("task3", 1900));
                delayQueue.offer(new MyDelayedTask("task4", 5900));
                delayQueue.offer(new MyDelayedTask("task5", 6900));
                delayQueue.offer(new MyDelayedTask("task6", 7900));
                delayQueue.offer(new MyDelayedTask("task7", 4900));

            }
        }).start();

        while (true) {
            Delayed take = delayQueue.take();
            System.out.println(take.toString());
        }
    }
}

/**
 * compareTo 方法必须提供与 getDelay 方法一致的排序
 */
class MyDelayedTask implements Delayed {

    private String name;
    private long start = System.currentTimeMillis();
    private long time;

    public MyDelayedTask(String name, long time) {
        this.name = name;
        this.time = time;
    }

    /**
     * 需要实现的接口，获得延迟时间   用过期时间-当前时间
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((start + time) - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 用于延迟队列内部比较排序   当前时间的延迟时间 - 比较对象的延迟时间
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        MyDelayedTask o1 = (MyDelayedTask) o;
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "MyDelayedTask{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
