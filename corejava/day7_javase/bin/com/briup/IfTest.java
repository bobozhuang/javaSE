package com.briup.chap03;

public class IfTest{
	public static void main(String[] args){
		//从程序外部拿到一个数字
		String s = args[0];
		int i = Integer.parseInt(s);
		if(i<10){
			System.out.println("hello");
		}else if(i<20){
			System.out.println("world");
		}else if(i<30){
			System.out.println("briup");
		}else{
			System.out.println("error");
		}

		if(i>100)
			System.out.println("hello");
			System.out.println("world");	




	}
}
