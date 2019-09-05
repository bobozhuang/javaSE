package com.briup.chap02;
/**  
 这是一个测试类
 @author zhao
 @version 1.0
 @since 1.8
 */
public class CommentsTest{
	public static void main(String[] args){
		int i;
		i = 100;
		System.out.println(i);
		/*int a = 10;
		int b = 20;
		System.out.println
			(new CommentsTest().sum(a,b));*/
	}
	//this method is sum
	//
	/* 
		test test test
	 */
	/**
		这是一个方法，用来求两个数的和
		@param a:第一个数
		@param b:第二个数
		@return 返回两数之和
	*/
	public int /* test */
		/*   python  */
		
		sum(int a,int b){
		int i = a + b;
		return i;
	}
}
