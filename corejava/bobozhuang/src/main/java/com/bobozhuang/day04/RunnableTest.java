package com.briup.chap09;

public class RunnableTest {
	public static void main(String[] args) {
		Runnable r  = new MyThread2();
		Runnable r1 = new MyThread2();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
		t1.start();
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		String name = 
				Thread.currentThread()
				.getName();
		for(int i = 0;i < 10;i++){
			System.out.println(name+":"+i);
		}
	}
}













