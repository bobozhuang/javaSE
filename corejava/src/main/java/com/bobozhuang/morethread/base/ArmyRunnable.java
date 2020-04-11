package main.java.com.bobozhuang.morethread.base;

//军队线程
//模拟作战双方的行为
public class ArmyRunnable implements Runnable {

	//volatile保证了线程可以正确的读取其他线程写入的值
	//可见性 ref jmm  java内存模型，happens-before原则
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		while(this.keepRunning) {
			//发动五连击
			for(int i = 0; i < 5; ++i) {
				System.out.println(Thread.currentThread().getName() + "进攻对方[" + i + "]");
				//让出了cpu，下次谁进攻还不知道
				Thread.yield();
				//如果此时具有相同优先级的其他线程处于就绪状态，那么yield()方法将把当前运行的线程放
				//到可运行池中并使另一个线程运行。如果没有相同优先级的可运行线程，则yield()方法什么也不 做。
			}
		}

		System.out.println(Thread.currentThread().getName() + "结束了战斗！");
	}

}
