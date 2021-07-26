package main.java.com.bobozhuang.morethread.threadstatus;

public class JoinTest {
    public static void main(String[] args)
            throws InterruptedException {
        Thread t = new MyThread7();
        //System.out.println("开始计算");
        Thread t1 = new MyThread7(t);
        t.start();
        t1.start();
        Thread.sleep(1000);
        System.out.println(t.getName() + ": " + t.getState());
        //t1.interrupt();

        //join写到了
        //哪个线程的代码块中，让哪个线程等待
        //直到 调用join方法的线程运行完，自己再去
        //运行
        //System.out.println("结束计算");
    }
}

class MyThread7 extends Thread {
    public Thread t;

    public MyThread7() {
    }

    public MyThread7(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if (t != null) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
                String name = Thread.currentThread().getName();
                System.out.println(name + ":" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



