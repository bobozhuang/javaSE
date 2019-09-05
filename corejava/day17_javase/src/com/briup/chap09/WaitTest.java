package com.briup.chap09;

public class WaitTest {
	public static void main(String[] args) 
			throws InterruptedException {
		Thread t1 = new MyThread10();
		Thread t2 = new MyThread10();
		t1.start();
		t2.start();
	}
}
class MyThread10 extends Thread{
	static int i ;
	@Override
	//this 
	//Static  类名.class
	public synchronized void run() {
		synchronized(MyThread10.class){
			try {
				String name = 
						Thread.currentThread()
						.getName();
				for(;i < 30 ;i++){
					if(i == 10){
						i++;
						MyThread10.class.wait();   
					}
					if(i == 20){
						i++;
						MyThread10.class.notifyAll();
						MyThread10.class.wait();
					}
					System.out.println
						(name+":"+i);
				}
				MyThread10.class.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


