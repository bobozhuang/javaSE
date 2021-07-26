package main.java.com.bobozhuang.morethread.threadstatus;


/**
 *
 */
public class WaitTest {
	public static void main(String[] args) 
			throws InterruptedException {
//		Thread t1 = new MyThread10();
//		Thread t2 = new MyThread10();
//		t1.start();
//		t2.start();

		Thread t11 = new MyThread11();
		Thread t12 = new MyThread12();
		t11.start();
		t12.start();
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


class MyThread11 extends Thread{


	@Override
	//this
	//Static  类名.class
	public synchronized void run() {
		int i = 0;
		synchronized(MyThread10.class){
			try {
				String name =
						Thread.currentThread()
								.getName();
				for(;i < 30 ;i++){
					if(i == 20){
						i++;
						MyThread10.class.wait();
					}
					if(i == 10){
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
class MyThread12 extends Thread{


	@Override
	//this
	//Static  类名.class
	public synchronized void run() {
		int i = 0;
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
					if(i == 25){
						i++;
						MyThread10.class.notifyAll();
//						MyThread10.class.wait();
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