package main.java.com.bobozhuang.threadlocal;

/**
 * description：
 * author Hubery
 * date 2020-04-19
 * version v0.0.1
 * since v0.0.1
 **/
public class Basic {

    // ThreadLocal<T>
    //public static ThreadLocal<Long> x = new ThreadLocal<Long>();
    public static ThreadLocal<Long> x = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            System.out.println("Initial Value run..");
            return Thread.currentThread().getId();//负值
        }
    };

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                System.out.println(x.get());
            }
        }.start();
        x.set(107L);
        // 移除当前线程上的ThreadLocal的值
        x.remove();
         /*
            get操作会延迟加载，如果不get,不会触发initialValue
         */
        System.out.println(x.get());//获取到主线程的 id


    }

}