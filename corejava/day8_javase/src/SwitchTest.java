package com.briup.chap03;
public class SwitchTest{
	public static void main(String[] args){
		String s = args[0];
		switch(s){
			case "1":
				System.out.println("星期一");
			case "2":
				System.out.println("星期二");
			case "3":
				System.out.println("星期三");
			default:
				System.out.println("error");
		}
	}
}
