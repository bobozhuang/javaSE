package main.java.com.bobozhuang.morethread;

public class MainThreadTest {
	public static void main(String[] args) {
		String name = Thread
				.currentThread()
					.getName();
		System.out.println(name);
		System.out.println("--------");
		new MainThreadTest().say();
	}
	public void say(){
		int i = 10;
		if(i > 5){
			String name = Thread
				.currentThread()
					.getName();
			System.out.println(name);
		}
		sleep();
	}
	public void sleep(){
		System.out.println("-------");
		for(int i = 0;i < 3;i++){
			String name = Thread
					.currentThread()
						.getName();
			System.out.println(name);
		}
		eat();
	}
	public void eat(){
		System.out.println("-------");
		try{
			int i = 10/0;
		}catch (Exception e) {
			String name = Thread
					.currentThread()
						.getName();
			System.out.println(name);
		}
	}
}




