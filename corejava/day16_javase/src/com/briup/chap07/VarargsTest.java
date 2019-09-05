package com.briup.chap07;

public class VarargsTest {
	// public void test(int a,int b,int c,int d)
	// public void test(int[] arr)
	// public void test()
	public void test(int... arr){
		System.out.println
			("参数个数:"+arr.length);
		if(arr.length>0){
			for (int i : arr) {
				System.out.println(i);
			}
		}
		System.out.println("--------");
	}
	public static void main(String... args) {
		VarargsTest vt = new VarargsTest();
		vt.test();
		vt.test(10,20,30);
		int[] arr = {40,50,60};
		vt.test(arr);
	}
	
}
