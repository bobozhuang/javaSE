package main.java.com.bobozhuang.stringDemo;

import java.util.Arrays;

public class StringTest {
	public static void main(String[] args) {
		//String表示字符串
		//是一个类，也就代表着String s
		//s是类类型
		//java为String制定了特殊规则
		//可以 像基本数据类型一样使用
		String s1 = "helloworld";
		String s2 = 
				new String("helloworld");
		String s3 = "helloworld";
		System.out.println(s1);
		System.out.println(s2);
		//-------------------
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s3);
		System.out.println("杰".getBytes());
		System.out.println
			(Arrays.toString
					("a".getBytes()));
		//[ ,  ,  ,  ,  , h, e, l, l,  ]
		char[] c = new char[10];
		s1.getChars
			(0, 4,c, 5);
		System.out.println
			(Arrays.toString(c));
		
		
		String str = 
				"101-张三-1995-男-打篮球";
		String[] infos = str.split("-");
		System.out.println
			(Arrays.toString(infos));
		String sub1 = 
				s1.substring(5,s1.length()-1);
		System.out.println(sub1);
	}
}
