package com.briup.chap05;

public class MethodTest{
	// 修饰符 返回值类型 方法名（参数列表）
	// throws 异常抛出类型{    }
	//1 修饰符 一个方法的修饰符可以有多个
	//但是要求修饰符之间不冲突 public static
	//2 void 代表没有返回值
	//  如果有返回值，那么用返回值的类型写在方法声明中
	//如果返回值类型不是void，方法体必须要写
	//return 语句 
	//  a，跳出方法代码块
	//  b，把返回值返回
	public int buy(){
		if(true){
			return 5;	
		}else{
			return 10;
		}
	
	//	return 10;
	} 
	//返回值类型为void
	//代码块中也可以用return
	//作用就只是跳出方法
	public void test1(){
		for(int i = 0;i < 10;i++){
			if(i==4)
				return;
		}
		System.out.println("hello world");
	}

	public void test2
		(int a,String b,double c){
		System.out.println("a:"+a
				+" b:"+b
				+" c:"+c);
	}
	//public int test2(int x,String y,double z){
	//	return 10;
	//}
	
	public void test3(int b){
		b += 10;
		System.out.println("test3:"+b);
	}

	public void test4(Teacher t){
		t.name = "lgd";
		System.out.println("test4:"+t.name);
	}

	public static void main(String[] args){
		// 1 如果方法声明的时候写了参数
		// 那么调用方法的时候必须传参数
		/*MethodTest mt = 
			new MethodTest();
		int  x= 10;
		String y = "hello";
		double z = 3.14;
		mt.test2(x,y,z);
		// 2 如果方法有返回值类型
		// 才能用变量去接收
		// 或者放入其他方法作为参数
		int i = mt.buy();
		System.out.println(mt.buy());
		System.out.println(mt.test1());
		*/
		MethodTest mt = 
			new MethodTest();
		int i = 10;
		System.out.println("main:"+i);
		mt.test3(i);
		System.out.println("main:"+i);
		System.out.println("-------");

		Teacher t = new Teacher();
		t.name = "张三";
		System.out.println("main:"+t.name);
		mt.test4(t);
		System.out.println("main:"+t.name);


	}

}

class Teacher{
	String name;
}





