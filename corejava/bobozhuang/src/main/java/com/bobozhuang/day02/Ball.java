package main.java.com.bobozhuang.day02;

public class Ball{	
	public void played(){
		System.out.println("正在玩球");
	}
}

class FootBall extends Ball{
	public void played(){
		System.out.println("用脚踢足球");
	}
}

class BusketBall extends Ball{
	public void played(){
		System.out.println("用手打篮球");
	}
}

class Person{

	public void playWithBall(Ball ball){
		ball.played();
	}

}

