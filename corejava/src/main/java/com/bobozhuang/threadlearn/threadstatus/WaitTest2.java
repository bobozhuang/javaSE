package threadstatus;

/**
 * description：     这里好像和wait没关系，是在讲中断，当kill掉进程是调用钩子函数
 * author Hubery
 * date 2020-09-22
 * version v0.0.1
 * since v0.0.1
 **/
public class WaitTest2 {

    public static void main(String[] args) {
        final Thread waitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread begin");

                //等待获取许可
                try {
                    Thread.sleep(100000);
                    System.out.println("sleep 100000s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //输出thread over.true
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

                try {
                    Thread.sleep(3000);
                    System.out.println("sleep 3s");//这里也是会执行的
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        waitThread.start();
        //绑定钩子
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitThread.interrupt();
                    waitThread.join();//哪个线程的代码块中，让哪个线程等待。直到 调用join方法的线程运行完，自己再去运行
                } catch (InterruptedException e) {
                    System.out.println("ShutdownHook");
                    e.printStackTrace();
                }
                System.out.println("shutdown success");
            }
        }));

    }
}
