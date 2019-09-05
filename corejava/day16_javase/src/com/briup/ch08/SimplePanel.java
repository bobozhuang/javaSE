package com.briup.ch08;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimplePanel {
	public static void main(String[] args) {
		//创建一个容器
		Frame f = new Frame("hello");
		
		//给窗口添加一个点击关闭的事件(就是点击关闭的时候执行什么方法去做什么事情)
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//创建一个Panel panel不能单独存在 要放在其他容器里面
		Panel p = new Panel();
		//创建一个按钮对象
		Button b = new Button("press me");
		//设置按钮的颜色
		b.setBackground(Color.red);
		//向panel中添加按钮
		p.add(b);
		//设在panel的背景颜色
		p.setBackground(Color.YELLOW);
		//把panel放在容器f中
		f.add(p);
		//设置容器的大小
		f.setSize(100,100);
		//设置容器可见
		f.setVisible(true);
	}
}
