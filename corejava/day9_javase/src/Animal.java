package com.briup.chap05;
import java.io.IOException;
public class Animal{
	public int id;
	protected String name;
	boolean gender;
	private double weight;
	
	public void eat() throws IOException{
		System.out.println("eat");
	}
	protected void sleep(){
		System.out.println("sleep");
	}
	void play(){
		System.out.println("play");
	}
	private void takeSh(){
		System.out.println("takeSh");	
	}

	public Animal(int i){
		System.out.println("Animal()");
	}
	


}
