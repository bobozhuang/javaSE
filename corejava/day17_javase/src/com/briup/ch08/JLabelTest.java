package com.briup.ch08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//标签
public class JLabelTest {
	//容器  (相当于一个桌子)
	private JFrame frame;
	//附属容器  (相当于桌子上的桌布)
	private Container container;
	//嵌套的容器 放到container北边
	private JPanel north;
	//标签
	private JLabel lable1,lable2,lable3;
	
	public JLabelTest() {
		//设置窗口的标题
		frame = new JFrame("JLabelTest");
		//获得容器中的附属容器
		container = frame.getContentPane();
		//设置frame的位置
		frame.setLocation(100, 100);
		//设置frame的大小
		frame.setSize(400, 400);
		//设置点击关闭后退出这个java程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//调用init方法初始化container中的组件
		init();
		//设置frame可见
		frame.setVisible(true);
	}
	private void init(){
		//初始化界面中的组件
		lable1 = new JLabel("test1");
		lable2 = new JLabel("test2");
		lable3 = new JLabel("test3");
		
		north = new JPanel();
		container.add(north,BorderLayout.NORTH);
		north.setLayout(new FlowLayout());
		north.add(lable1);
		north.add(lable2);
		north.add(lable3);
	}
	
	public static void main(String[] args) {
		
		new JLabelTest();
		
	}
}
