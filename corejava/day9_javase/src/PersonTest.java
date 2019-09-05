package com.briup.chap05;

public class PersonTest{
	public static void main(String[] args)
		throws Exception{
		Person p = new Person();
		String name = args[0];
		Class c = Class.forName(name);
		Object o = c.newInstance();
		Ball b = (Ball)o; 
		p.playWithBall(b);
		//----------------
		Ball ball = new BusketBall();
		ball.test();


	}
}

