package main.java.com.bobozhuang.collection.queue.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description： delay 延期；耽搁
 * author Hubery
 * date 2020-09-16
 * version v0.0.1
 * since v0.0.1
 **/
public class DelayTask implements Delayed {
    private static long currentTime = System.currentTimeMillis();
    protected final String taskName;
    protected final int timeCost;   //timeCost表示处理此任务需要的时间，本示例中为2s
    protected final long scheduleTime;//定时执行的时间

    protected static final AtomicInteger taskCount = new AtomicInteger(0);

    // 定时任务之间的启动时间间隔在1~2s之间，timeCost表示处理此任务需要的时间，本示例中为2s
    public DelayTask(String taskName, int timeCost) {
        this.taskName = taskName;
        this.timeCost = timeCost;
        taskCount.incrementAndGet();
        double random = Math.random();
        if (0.6 > random && random >0.2){
            random = random - 0.2;

        }
//        System.out.println("random : " + random);
        currentTime += 1000 + (long) (random * 4000);
//        currentTime += 2000;
        scheduleTime = currentTime;
        System.out.println(taskName + " scheduleTime : " + scheduleTime);
    }

    @Override
    public int compareTo(Delayed delayed) {
        //智障了，想了半天想不起来 这是哪里的时间在做比较
        //当入队时调用这个方法，this就是入队 调用put 方法的 那个对象，减去的是已经入队的对象的scheduleTime时间属性
        int a = (int) (this.scheduleTime - ((DelayTask) delayed).scheduleTime);
//        System.out.println(this.taskName + " compareTo: " + a);
        return a;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long expirationTime = scheduleTime - System.currentTimeMillis();
        return unit.convert(expirationTime, TimeUnit.MILLISECONDS);
    }

    public void execTask() {
        long startTime = System.currentTimeMillis();
        System.out.println("Task " + taskName + ": schedule_start_time=" + scheduleTime + ",real start time="
                + startTime + ",delay=" + (startTime - scheduleTime));
        try {
            Thread.sleep(timeCost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "DelayTask{" +
                "taskName='" + taskName + '\'' +
                ", timeCost=" + timeCost +
                ", scheduleTime=" + scheduleTime +
                '}';
    }
}
