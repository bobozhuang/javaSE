package threadstatus;

/**
 * description：interrupt只是设置中断状态，并不会使程序暂停，会继续执行，如果需要显示地暂停程序，
 * 必须catch这个InterruptedException，那么catch捕捉到中断就不会继续try代码块程序了，该执行catch中代码了；
 * 可以对指定线程调用.interrupt()方法；
 * catch后暂停程序执行
 * author Hubery
 * date 2020-09-08
 * version v0.0.1
 * since v0.0.1
 **/
public class InterruptThread1 {
    int count = 1;

    public static void main(String[] args) {
        test2();
    }

    public static void test2() {

        Thread t11 = new T11();

        t11.start();

        try {
            t11.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t11.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

/**
 * 让线程可以结合业务场景灵活地处理自身的中断状态
 */
class T11 extends Thread {

    @Override
    public void run() {
        int a = 0;

        try {
            while (true) {
                Thread.sleep(1000l);//阻塞状态，线程被调用了interrupte（）方法，清除中断标志，抛出InterruptedException
                //dosomething
                boolean isIn = this.isInterrupted();

                System.out.println("isIn: " + a + "  " + isIn);
                //运行状态，线程被调用了interrupte（）方法，中断标志被设置为true
                //非阻塞状态中进行中断线程操作
                if (isIn) break;//退出循环，中断进程
                a++;
                if (a == 10) {

                    this.interrupt();
                    //boolean interrupted = Thread.interrupted();// 这个方法执行后就清除中断标志了
                    //boolean interrupted = this.interrupted();// 这个方法执行后就清除中断标志了
                    boolean interrupted = this.isInterrupted();// 这个方法执行后就不会清除中断标志
                    System.out.println("isIn: " + a + "  " + interrupted);
                }
            }
        } catch (InterruptedException e) {//阻塞状态中进行中断线程操作
            boolean isIn = this.isInterrupted();//退出阻塞状态，且中断标志被清除，重新设置为false，所以此处的isIn为false
            return;//退出run方法，中断进程
        }
    }
}

