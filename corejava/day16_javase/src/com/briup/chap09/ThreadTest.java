package com.briup.chap09;

public class ThreadTest {
	public static void main(String[] args) {
		//开启新的线程
		//JVM 默认执行的线程就是main
		// 开启自定义线程，也得依赖于main
		Thread t = new MyThread1();
		Thread t1 = new MyThread1();
		t.setName("李狗蛋");
		t1.setName("刘村花");
		//开启线程 start
		t.start();
		t1.start();
	}
}

class MyThread1 extends Thread{
	//自定义线程，继承父类
	//描述自定义线程要执行的代码
	//只需要重写父类中的run();
	@Override
	public void run() {
		String name = 
				Thread.currentThread()
				.getName();
		for(int i = 0;i < 10;i++){
			if(i == 5){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(name+":"+i);
		}
	}
	
}




