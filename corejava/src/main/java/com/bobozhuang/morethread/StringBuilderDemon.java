package main.java.com.bobozhuang.morethread;

/**
 * description： 线程不安全的会报错java.lang.ArrayIndexOutOfBoundsException
 * author Hubery
 * date 2019-10-11
 * version v0.0.1
 * since v0.0.1
 **/
public class StringBuilderDemon {

    public static void main(String[] args) throws InterruptedException {
        //StringBuilder str = new StringBuilder();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++){
                        str.append("a");
                    }
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println(str.length());
    }
}