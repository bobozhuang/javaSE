package main.java.com.bobozhuang.morethread;

import java.util.Date;

/**
 * i是静态成员变量，所以两个线程都会访问到，在并发很高的时候i++并不是原子操作，结果会小于20
 * 解决并发问题有很多种方式：以下通过synchronized实现
 * 给 str 加锁了，
 */
public class SameVarTest {
	public static void main(String[] args) {
		Thread t = new MyThread8();
		Thread t1 = new MyThread8();
		t.start();
		t1.start();
	}
}

class MyThread8 extends Thread {
	static int i = 0;
	Date d = new Date();
	String str = "helloworld";
	@Override
	public void run() {
//		synchronized (str) {
			for (; i <= 20; i++) {
				String name = Thread.currentThread().getName();
				System.out.println(name + ":" + i);
//				if (i == 10) {	//通过结束循环的方式释放锁
//					i++;
//					break;
//				}
//			}
		}
	}
}
