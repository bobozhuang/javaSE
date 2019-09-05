package com.briup.chap06;

public class Pig extends Animal
		implements Food,Pet{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Animal a = new Pig();
		Food f = new Pig();
		Pet p = new Pig();
	}
	
	
	
}
