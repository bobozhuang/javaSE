package main.java.com.bobozhuang.morethread; /**
 * description： 优雅地停止一个线程、
 *              当线程进入 runnable 状态之后，通过设置一个标识位，线程在合适的时机，检查该标识位，
 *              发现符合终止条件，自动退出 run () 方法，线程终止。
 *
 * author Hubery
 * date 2020-11-10
 * version v0.0.1
 * since v0.0.1
 * 模拟系统监控
 */
public class TestSystemMonitor {

    public static void main(String[] args) {
        testSystemMonitor();//测试系统监控器
    }

    /**
     * 测试系统监控器
     */
    public static void testSystemMonitor() {
        SystemMonitor sm = new SystemMonitor();
        sm.start();
        try {
            //运行 10 秒后停止监控
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("监控任务启动 10 秒后，停止...");
        sm.stop();
    }

}

/**
 * 系统监控器
 * @author
 */
class SystemMonitor {

    private Thread t;

    private volatile boolean stop = false;

    /**
     * 启动一个线程监控系统
     */
    void start() {
        t = new Thread(() -> {
            while (!stop) {//判断当前线程是否被打断        需要中断时就不去进行监控了
                System.out.println("正在监控系统...");
                try {
                    Thread.sleep(3 * 1000L);//执行 3 秒
                    System.out.println("任务执行 3 秒");
                    System.out.println("监控的系统正常!");
                } catch (InterruptedException e) {
                    System.out.println("任务执行被中断...");
                    Thread.currentThread().interrupt();//重新设置线程为中断状态
                }
            }
        });
        t.start();
    }

    void stop() {
        stop = true;
        t.interrupt();
    }
}