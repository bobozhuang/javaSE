package com.briup.ch08;

import java.awt.Button;
import java.awt.Frame;

//自定义布局
public class ManualLayout {
	public static void main(String[] args) {
		//创建一个容器对象
		Frame f = new Frame("hello");
		//取消布局管理器  Frame默认是BorderLayout
		f.setLayout(null);
		//宽300, 高100
		f.setSize(300,100);     
		//创建一个按钮对象
		Button b = new Button("press me");
		//宽100, 高30
		b.setSize(100,30);   
		//x坐标40, y坐标60
		b.setLocation(80,60);
		//把按钮添加到容器中
		f.add(b);
		//设置容器可见
		f.setVisible(true);
	}
}
