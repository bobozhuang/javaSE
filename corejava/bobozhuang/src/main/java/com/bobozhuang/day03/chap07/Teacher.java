package main.java.com.bobozhuang.day03.chap07;

public class Teacher<N> {
	N id;
	N weight;
	
	public N getId(){
		return this.id;
	}
	
	public void setId(N id){
		this.id = id;
	}
	
}
