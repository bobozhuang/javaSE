package com.briup.chap06;

public class WrapperTest {

	public static void main(String[] args) {
		//java5.0  之前
		//包装类和基本数据类型之间不能直接转化
		Integer in = new Integer(10);
		int i = in.intValue();
		//java5.0 之后
		//自动装箱 自动拆箱
		Integer in1 = 100;
		int j = in1;
		
		String str = "10";
		int m = Integer.parseInt(str);
		int n = 100;
		String str1 = Integer.toString(n);
		
		
	}

}
