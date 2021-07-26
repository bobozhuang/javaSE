package main.java.com.bobozhuang.morethread.threadstatus;

/**
 * description：
 * author Hubery
 * date 2020-09-08
 * version v0.0.1
 * since v0.0.1
 **/
public class InterruptScene1 {

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("HasInterruptEx");
        endThread.start();
        Thread.sleep(500);
        endThread.interrupt();   //中断线程，其实是设置一个线程的中断标识位
    }

    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        public void run() {

            while (!isInterrupted()) {               //这里会改成FLASE
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {   //该异常会把当前线程的中断标识位修改为FALSE
                    System.out.println(Thread.currentThread().getName()
                            + " in InterruptedException interrupt flag is " + isInterrupted());
                    //重点，当抛出异常的时候线程并没有中断，正确方式是在catch段里面加上该方法，该方法会把标识位改成TRUE
                    interrupt();
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " i am extends Thread.");
            }

            System.out.println(Thread.currentThread().getName()
                    + " interrupt flag is " + isInterrupted());
        }
    }

}
