package main.java.com.bobozhuang.threadlocal.my;

/**
 * description：
 * author Hubery
 * date 2020-05-07
 * version v0.0.1
 * since v0.0.1
 **/
public class Test {

    static MyThreadLocal<Long> v = new MyThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };



    public static void main(String[] args) {
        final int o;
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(v.get());
            }).start();
        }
    }

}
