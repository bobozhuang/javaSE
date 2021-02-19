package main.java.com.imooc.concurrent.base;

public class KeyPersonThread extends Thread {

	public void run(){
		System.out.println(Thread.currentThread().getName()+"��ʼ��ս����");
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"��ͻ��ɱ,�������...");
		}
		System.out.println(Thread.currentThread().getName()+"������ս����");
	}
}
