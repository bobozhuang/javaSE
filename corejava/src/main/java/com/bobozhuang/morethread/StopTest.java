package main.java.com.bobozhuang.morethread;

public class StopTest {
	public static void main(String[] args) throws InterruptedException {
		MyThread3 t = new MyThread3(true);
		t.start();
		Thread.sleep(5000);
	//	t.flag = false;
		t.stop();
	}
}
class MyThread3 extends Thread{
	public boolean flag = true;
	public  MyThread3(boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		while(flag){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hello");
		}
	}
}



