package com.briup.chap06;

public class AnonymousInnerClass {
	//给变量赋值
	//有父子类关系或者实现类和接口的关系
	//The type new Phone(){} must implement the inherited 
	//abstract method Phone.contact()
	public void test(){
		final int j = 10;
		Phone phone = new /*x extends*/ Phone(){
			private int i = 10;
			@Override
			public void contact() {
				System.out.println(j);
			}
		};
		Gameplayer g = new /*x implements*/ Gameplayer(){
			@Override
			public void playGame() {
			}
		};
		Pig pig = new Pig(){
			@Override
			public void eated() {
				// TODO Auto-generated method stub
				super.eated();
			}
		};
		Pig pig1 = new Pig(){
			@Override
			public void eated() {
				// TODO Auto-generated method stub
				super.eated();
			}
		};
		
	}

}
