package main.java.com.bobozhuang.morethread.threadstatus;

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
        //System.out.println("begain1:" + Thread.interrupted());
        System.out.println("begain2:" + t.isInterrupted());
        t.interrupt();
        System.out.println("end1:" + t.isInterrupted());
        System.out.println("end2:" + Thread.interrupted());//通过Thread.interrupted()调用永远时false，因为时主线程，并不时线程t
        //System.out.println("end:" + t.isInterrupted());

    }

}

class T2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

            System.out.print("");
            if (i == 500){
                System.out.println("-" + Thread.currentThread().interrupted());//这里才能正常返回
            }
        }
    }


}
