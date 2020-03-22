public class DeadLockTest {
	public static void main(String[] args) {
		Source A = new Source();
		Source B = new Source();
		Thread t1 = new TestAB(A, B);
		Thread t2 = new TestBA(A, B);
		t1.start();
		t2.start();
	}
}
class TestAB extends Thread{
	Source A;
	Source B;
	public TestAB(Source A,Source B){
		this.A = A;
		this.B = B;
	}
	@Override
	public void run() {
		String name = Thread.currentThread()
				.getName();
		while(true){
			synchronized (A) {
				System.out.println
					(name+"拿到了A,准备去拿B");
				synchronized (B) {
					System.out.println
						(name+"拿到了A又拿到了B,运行完毕");
				}
			}
		}
	}
}
class TestBA extends Thread{
	Source A;
	Source B;
	public TestBA(Source A,Source B){
		this.A = A;
		this.B = B;
	}
	@Override
	public void run() {
		String name = Thread.currentThread()
				.getName();
		while(true){
			synchronized (B) {
				System.out.println
					(name+"拿到了B,准备去拿A");
				synchronized (A) {
					System.out.println
						(name+"拿到了B又拿到了A,运行完毕");
				}
			}
		}
	}
}
class Source{
	
}





