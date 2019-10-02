package com.briup.ch08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//流式布局管理器
public class FlowLayoutTest {
	//容器  (相当于一个桌子)
	private JFrame frame;
	//附属容器  (相当于桌子上的桌布)
	private Container container;
	
	//定义一个JButton类型的数组
	private JButton[] buts;
	//定义一个panel:次级容器,可以用嵌套使用
	private JPanel panel;
	
	public FlowLayoutTest() {
		//设置窗口的标题
		frame = new JFrame("this is BorderLayout");
		//获得容器中的附属容器
		container = frame.getContentPane();
		//设置frame的位置
		frame.setLocation(100, 100);
		//设置frame的大小
		frame.setSize(400, 300);
		//设置点击关闭后退出这个java程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//调用init方法初始化container中的组件
		init();
		//设置frame可见
		frame.setVisible(true);
	}
	
	private void init(){
		//初始化panel
		panel = new JPanel();
		
		//设置container的布局管理器为BorderLayout
		//其实它默认布局管理器也是BorderLayout
		container.setLayout(new BorderLayout());
		
		
		//container.add(center)这样写和下面的效果是一样的
		//如果你不指定放到BorderLayout那个位置的时候
		//他会默认的把组件放到中间那个位置
		container.add(panel);
		
		//给panel设置一个布局管理器FlowLayout
		//其实panel默认的布局管理器也是FlowLayout
		panel.setLayout(new FlowLayout());
		
		//创建数组对象并指明数组长度
		buts = new JButton[50];
		//循环产生50个按钮并且放在panel中
		for(int i=1;i<=buts.length;i++){
			if(i<10){
				buts[i-1] = new JButton("0"+i);
			}else if (i<=50) {
				buts[i-1] = new JButton(""+i);
			}
			panel.add(buts[i-1]);
		}
		
	}
	
	public static void main(String[] args) {
		new FlowLayoutTest();
	}
	
	
}