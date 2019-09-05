package com.briup.chap05;

public class Cat extends Animal{
	//子类中使用父类中的属性和方法
	//直接使用，并不是先拿到父类对象
	private int id;
	public void test(){
		id = 101;
		name = "盼盼";
		gender = true;
		eat();
		sleep();
		play();
	}

	public void eat(){
		System.out.println("Cat eat()");
	}


	
	public Cat(){
		super(10);
		System.out.println("Cat()");
		System.out.println(this);
	}

	public static void main(String[] args){
		new Cat();

		Cat c = new Cat();
		c.eat();

		Animal a = new Animal();
		a.eat();

		Animal an = new Cat();
		an.eat();



	}

}
