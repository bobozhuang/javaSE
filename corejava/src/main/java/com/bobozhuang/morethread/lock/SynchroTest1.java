package main.java.com.bobozhuang.morethread.lock;

import java.util.Date;

public class SynchroTest1 {
	public static void main(String[] args) {
		Runnable r1 = new MyThread9();
		// Runnable r2 = new MyThread9();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	}
}

class MyThread9 implements Runnable {
	static int i = 0;
	Date d = new Date();
	String str = "helloworld";

	@Override
	public void run() {
		// Class.for("MyThread8");
		// new MyThread8().getClass()
		// MyThread8.class
		synchronized (this) {
			for (; i <= 20; i++) {
				String name1 = 
						Thread.currentThread()
						.getName();
				System.out.println(name1 + ":" + i + " 里");
				if (i == 10) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					i++;
					break;
				}
			}
		}
	}
}
