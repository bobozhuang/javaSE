package com.briup.ch09;

//事件监听器 (相当于例子的男孩)
public interface EmotionListenner {
	
	void happy(EmotionEvent e);
	void sad(EmotionEvent e);
}