package com.briup.ch09;

public class EmotionTest {
	
	public static void main(String[] args) {
		//事件源
		EmotionSource girl = new EmotionSource("lily2");
		
		girl.addActionListenner(new EmotionListenner() {
			
			@Override
			public void sad(EmotionEvent e) {
				EmotionSource girl = (EmotionSource) e.getSource();
				String name = girl.getName();
				System.out.println("I am the listenner-boy and I am so Sad too because "+name+" is Sad");
			}
			
			@Override
			public void happy(EmotionEvent e) {
				EmotionSource girl = (EmotionSource) e.getSource();
				String name = girl.getName();
				System.out.println("I am the listenner-boy and I am so Happy too because "+name+" is Happy");
				
			}
		});
		
		girl.happy();
	}
	
}
