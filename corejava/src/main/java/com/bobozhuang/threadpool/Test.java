package main.java.com.bobozhuang.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description：https://juejin.im/entry/587601a7b123db4a2ed68485
 * author Hubery
 * date 2020-04-01
 * version v0.0.1
 * since v0.0.1
 **/
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor;
        executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() +
                    "，队列中等待执行的任务数目：" + executor.getQueue().size() +
                    "，已执行完的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();

        ThreadPoolExecutor executor1;
        executor1 = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 25; i < 40; i++) {
            int a = i % 2;
            PlayBasketball playBasketball = null;
            PlayPingPong playPingPong = null;
            if (a == 1) {
                playBasketball = new PlayBasketball(i);
                executor1.execute(playBasketball);
            } else {
                playPingPong = new PlayPingPong(i);
                executor1.execute(playPingPong);
            }

            System.out.println("线程池中线程数目：" + executor1.getPoolSize() +
                    "，队列中等待执行的任务数目：" + executor1.getQueue().size() +
                    "，已执行完的任务数目：" + executor1.getCompletedTaskCount());
        }
        executor.shutdown();
        System.out.println("-----------------------------");
    }


}

class PlayBasketball implements Runnable {
    private int taskNum;

    public PlayBasketball(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        int i = 0;
        while (i < 10) {
            try {
                Thread.sleep(500);
                System.out.println("啪啪：" + taskNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PlayPingPong implements Runnable {
    private int taskNum;

    public PlayPingPong(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        int i = 0;
        while (i < 10) {
            try {
                Thread.sleep(500);
                System.out.println("乒乓：" + taskNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        int i = 0;
        while (true) {
            try {
                Thread.currentThread().sleep(500);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i > 10) {
                break;
            }
            System.out.println("task " + taskNum + "---");
        }

        System.out.println("task " + taskNum + "执行完毕");
    }
}