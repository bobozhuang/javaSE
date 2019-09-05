package com.briup.chap09;

public class InterruptTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new MyThread5();
		t.start();
		Thread.sleep(5000);
		t.interrupt();
	}
}

class MyThread5 extends Thread{
	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(i);
			if(i == 4){
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}



