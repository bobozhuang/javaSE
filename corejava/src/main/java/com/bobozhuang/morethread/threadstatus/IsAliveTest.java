package main.java.com.bobozhuang.morethread.threadstatus;

public class IsAliveTest {
	public static void main(String[] args) 
			throws InterruptedException {
		Thread t = new MyThread4();
		t.start();
		while (true) {
			Thread.sleep(500);
			System.out.println
				(t.isAlive());
		}
	}
}
class MyThread4 extends Thread{
	@Override
	public void run() {
		for(int i = 0;i < 10;i++){
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}



