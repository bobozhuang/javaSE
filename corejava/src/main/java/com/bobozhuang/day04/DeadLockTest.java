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
					(name+"�õ���A,׼��ȥ��B");
				synchronized (B) {
					System.out.println
						(name+"�õ���A���õ���B,�������");
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
					(name+"�õ���B,׼��ȥ��A");
				synchronized (A) {
					System.out.println
						(name+"�õ���B���õ���A,�������");
				}
			}
		}
	}
}
class Source{
	
}





