package main.java.com.bobozhuang.morethread.threadstatus;

import main.java.com.bobozhuang.morethread.threadcommunication.Run;

/**
 * description：
 * author Hubery
 * date 2020-12-03
 * version v0.0.1
 * since v0.0.1
 **/
public class BuildThreadThree extends Thread{

    public static void main(String[] args) {
        BuildThreadThree t1 = new BuildThreadThree();
        t1.start();
        System.out.println("A");
    }


    @Override
    public void run() {
        System.out.println("B");
        p();
    }

    public void p(){
        System.out.println("C");
    }

    @Override
    public synchronized void start() {
        System.out.println("D");
    }
}

class MyTask extends Thread{

    @Override
    public void run() {
        super.run();
    }
}
