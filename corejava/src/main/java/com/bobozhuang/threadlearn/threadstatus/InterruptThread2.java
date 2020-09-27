package threadstatus;

/**
 * description： interrupted 只能对当前线程调用
 *      会清空原有的interrupt状态，例如在上段代码输出结果是false，因为interruptedException捕捉到后，
 *      将中断状态恢复了，这点区别于isInterrupted（）
 *
 * author Hubery
 * date 2020-09-08
 * version v0.0.1
 * since v0.0.1
 **/
public class InterruptThread2 {

    int count = 1;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Thread t = new Thread(new T2(), "T2");
        t.start();
        System.out.println("begain:" + Thread.interrupted());
//        System.out.println("begain:" + t.isInterrupted());
        t.interrupt();
        System.out.println("end:" + Thread.interrupted());
//        System.out.println("end:" + t.isInterrupted());

    }

}

class T2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
//            System.out.println(Thread.currentThread().interrupted());
        }
    }


}
