import java.util.Date;

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
		// Class.for("MyThread8");
		// new MyThread8().getClass()
		// MyThread8.class
		synchronized (str) {
			for (; i <= 20; i++) {
				String name = Thread.currentThread().getName();
				System.out.println(name + ":" + i);
				if (i == 10) {
					i++;
					break;
				}
			}
		}
	}
}
