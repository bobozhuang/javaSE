package main.java.com.bobozhuang.collection.queue.delayqueue;

import java.util.concurrent.BlockingQueue;

/**
 * description：
 * author Hubery
 * date 2020-09-16
 * version v0.0.1
 * since v0.0.1
 **/
public class DelayTaskComsumer extends Thread {

    private final BlockingQueue<DelayTask> queue;

    public DelayTaskComsumer(BlockingQueue<DelayTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        DelayTask task = null;
        try {
            while (true) {
                task = queue.take();
                task.execTask();
                DelayTask.taskCount.decrementAndGet();
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " finished");
        }
    }


}
