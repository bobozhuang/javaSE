package main.java.com.bobozhuang.collection.queue.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * description：     DelayQueue的一个应用场景是定时任务调度。本例中先让主线程向DelayQueue添加１０个任务，
 *                  任务之间的启动间隔在1~2s之间，每个任务的执行时间固定为2s，代码如下：
 *
 *https://blog.csdn.net/dkfajsldfsdfsd/article/details/88966814?biz_id=102&utm_term=DelayQueue&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-88966814&spm=1018.2118.3001.4187
 *                  首先启动一个消费者线程。因为消费者线程处理单个任务的时间为2s，而任务的调度间隔为1~2s。这种情况下，
 *                  每当消费者线程处理完一个任务，回头再从队列中新取任务时，新任务肯定延期了，无法按给定的时间调度任务。
 *                  而且越往后情况越严重。运行代码看一下输出
 * author Hubery
 * date 2020-09-16
 * version v0.0.1
 * since v0.0.1
 **/
public class DelayQueueTest1 {

    public static void main(String[] args) {

        BlockingQueue<DelayTask> queue = new DelayQueue<DelayTask>();

        for (int i = 0; i < 10; i++) {
            try {
                queue.put(new DelayTask("work " + i, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("queue: " + queue.toString());
        ThreadGroup g = new ThreadGroup("Consumers");

        for (int i = 0; i < 1; i++) {
            new Thread(g, new DelayTaskComsumer(queue)).start();
        }

        while (DelayTask.taskCount.get() > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        g.interrupt();
        System.out.println("Main thread finished");
    }


}
