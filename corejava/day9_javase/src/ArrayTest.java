package com.briup.chap04;
import java.util.Arrays;
public class ArrayTest{
	public static void main(String[] args){
		int[] i = new int[10];
		i[0] = 10;
		i[1] = 20;
		i[2] = 30;
		System.out.println(i.length);
		//遍历数组
		for(int j = 0; j < i.length ;j++ ){
			System.out.println(i[j]);
		}

		System.out.println
			(Arrays.toString(i));
		//增强for
		//只能用于遍历数组或者集合
		System.out.println("------");
		for(int m : i){
			System.out.println(m);
		}
	}

}
