package com.briup.chap03;
//Pojo  plain old java objects
//javabean  框架中
public class Teacher{
	//1 属性，共同特征
	//修饰符  类型 变量名， 类内 方法外
	private int id;
	private String name;
	private boolean gender = true;
	private double salary;
	//2 无参构造器
	//修饰符 类名(){}
	public Teacher(){
		this(101,"zhangsan");
		System.out.println("构造器:"+this);
	}
	public Teacher(int id,String name){
		this(id,name,false,10000.0);
		this.id = id;
		this.name = name;
	}
	public Teacher(int id,String name,
			boolean gender,double salary){
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}


	//3 get/set方法
	public int getId(){
		return id;
	}	
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	//4 普通方法，共同行为
	public void teach(){
		System.out.println(name+" is teaching java!");
		test();
	}
	public void test(){
		System.out.println("hello");
	}
	public static void main(String[] args){
		Teacher t = new Teacher();
		System.out.println("main:"+t);
		t.getId();
		Teacher t1 = new Teacher();
		System.out.println("main:"+t1);

		
	
	}


	
}
