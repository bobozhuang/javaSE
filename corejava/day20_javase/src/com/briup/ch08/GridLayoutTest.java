package com.briup.ch08;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//网格布局管理器
public class GridLayoutTest {
	//容器窗口  (相当于一个桌子)
	private JFrame frame;
	//附属容器  (相当于桌子上的桌布)
	private Container container;
	//按钮数组
	private JButton[] buts;
	
	public GridLayoutTest() {
		//设置窗口的标题
		frame = new JFrame("this is GridLayoutTest");
		//获得容器中的附属容器
		container = frame.getContentPane();
		//设置frame的位置
		frame.setLocation(100,100);
		//设置frame的大小
		frame.setSize(500,500);
		//设置点击关闭后退出这个java程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//调用init方法初始化container中的组件
		init();
		//设置frame可见
		frame.setVisible(true);
	}
	
	private void init(){
		//创建按钮数组对象
		buts = new JButton[9];
		
		//设置container的布局管理器为GridLayout
		//GridLayout(3,3)表示布局为3行3列
		container.setLayout(new GridLayout(3,3));
		
		//循环创建按钮并放到container中
		for(int i=0;i<buts.length;i++){
			buts[i] = new JButton((i+1)+"");
			container.add(buts[i]);
		}
		
	}
	
	public static void main(String[] args) {
		new GridLayoutTest();
	}
	
	
}
