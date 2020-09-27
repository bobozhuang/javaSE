package threadstatus;

/**
 * 测试interrupt()设置中断，sleep时发现中断标识抛出异常
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread5();
        t.start();
        Thread.sleep(2000);//线程t睡8秒，主线程睡2秒后 设置中断，线程t会抛出中断异常，结束sleep
        t.interrupt();
    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 4) {

                try {
                    Thread.sleep(8000);
                    System.out.println("sleep end ！");//当设置了 中断标志sleep抛异常就不执行了
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



