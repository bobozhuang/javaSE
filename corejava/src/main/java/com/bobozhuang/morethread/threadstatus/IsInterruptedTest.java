package main.java.com.bobozhuang.morethread.threadstatus;

/**
 *  interrupt设置中断状态true，
 *  isInterrupted返回是否中断状态，
 *  interrupted返回是否中断状态并清除状态置为false
 */
public class IsInterruptedTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread6();
        t.start();
        Thread.sleep(1);
        t.interrupt();
    }
}

class MyThread6 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i == 50){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);
            System.out.println(Thread.interrupted());
            System.out.println(this.isInterrupted());
        }
    }
}




