package main.java.com.bobozhuang.stringDemo;

/**
 * description：        String 字符串常量
 *                      StringBuffer 字符串变量（线程安全）
 *                      StringBuilder 字符串变量（非线程安全）
 * author Hubery
 * date 2020-10-10
 * version v0.0.1
 * since v0.0.1
 **/
public class StringBufferDemo {

    public static void main(String[] args) throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++){
                        stringBuffer.append("a");
                    }
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println(stringBuffer.length());


    }

}
