package threadstatus;

/**
 * description：isInterrupted
 *              可以对指定线程调用；
 *              不改变中断状态，和interrupted区别开来；
 * author Hubery
 * date 2020-09-08
 * version v0.0.1
 * since v0.0.1
 **/
public class InterruptThread3 {

    int count = 1;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Thread t = new Thread(new T3(), "T3");
        t.start();
        t.interrupt();

    }
}

class T3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }

}
