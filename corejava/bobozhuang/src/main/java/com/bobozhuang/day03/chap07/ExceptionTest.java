package main.java.com.bobozhuang.day03.chap07;

public class ExceptionTest {
	public static void main(String[] args) throws Exception{
		new ExceptionTest().test1();
		System.out.println("测试程序是否继续运行");
	}
	
	public void goToWork(String str)throws MyWorkException{
		if(str.equals("天气晴朗")){
			System.out.println("开开心心去上班~");
		}
		if(str.equals("下雨了")){
			System.out.println("下雨了还要上班，好难过呀~");
		}
		if(str.equals("被车撞了")){
			throw new MyWorkException("被车撞了，去医院了~");
		}
	}
	
	
	public void test1() {
		//要么是自己写的语句出现异常
		//int i = 10/0;
		//要么是调用了方法出现异常
		//Class.forName("abc");
		//异常是不符合执行逻辑的代码
		//所以异常的最开始产生，往往依赖于
		//条件判断，不符合逻辑的 条件分支中
		//使用throw 抛出异常对象
		
		//异常的处理方式两种
		//把异常继续抛出，谁调用test1谁接收
		
		//把异常在程序内部进行处理
		
		try{
			goToWork("被车撞了");
		}catch (MyWorkException e) {
			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println(msg);
		}finally {
			System.out.println("必须要回去写完代码");
		}
		
	}
	public void test2()throws Exception{
		test1();
	}
	public void test3()throws Exception{
		test2();
	}
	public void test4()throws Exception{
		test3();
	}
	
}
