package com.briup.chap09;

public class IsInterruptedTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new MyThread6();
		t.start();
		Thread.sleep(1);
		t.interrupt();
	}
}

class MyThread6 extends Thread{
	@Override
	public void run() {
		for(int i = 0 ; i < 100;i++ ){
			System.out.println
				(Thread.interrupted());
		}
	}
}




