package main.java.com.bobozhuang.morethread.base;

/**
 * 舞台
 */
public class Stage extends Thread {
	public Stage() {
	}

	public void run() {
		System.out.println("欢迎观看隋唐演义");

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException var11) {
			var11.printStackTrace();
		}

		System.out.println("大幕徐徐拉开");

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException var10) {
			var10.printStackTrace();
		}

		System.out.println("话说隋朝末年，隋军与农民起义军杀得昏天黑地...");
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");
		armyOfSuiDynasty.start();
		armyOfRevolt.start();

		try {
			Thread.sleep(50L);
		} catch (InterruptedException var9) {
			var9.printStackTrace();
		}

		System.out.println("正当双方激战正酣，半路杀出了个程咬金");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException var8) {
			var8.printStackTrace();
		}

		mrCheng.start();

		try {
			mrCheng.join();//挂起当前线程（一般是主线程），直至它所调用的线程终止才被运行，这样就不会在程咬金杀的时候 出现战争结束
		} catch (InterruptedException var7) {
			var7.printStackTrace();
		}

		System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
		System.out.println("谢谢观看隋唐演义，再见！");
}

	public static void main(String[] args) {
		(new Stage()).start();
	}
}
