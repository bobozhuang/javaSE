package com.briup.chap05;

public class OverLoadingTest{
	public void test(){
		System.out.println("test()");
	}
	public void test(short s){
		System.out.println("test(short)");
	}
	public int test(int i){
		System.out.println("test(int)");
		return 10;
	}
	public void test(int i,double d){
		System.out.println("test(int,double)");
	}
	public void test(double d,int i){
		System.out.println("test(double,int)");
	}

	public static void main(String[] args){
		OverLoadingTest ol = 
			new OverLoadingTest();
		ol.test();
		byte b = 10;
		ol.test(b);
		ol.test(10,20);
	
	}

}
