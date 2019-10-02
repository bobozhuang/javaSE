package com.briup.ch08;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

//卡片布局管理器
public class CardLayoutTest {
	//容器窗口  (相当于一个桌子)
	private JFrame frame;
	//附属容器  (相当于桌子上的桌布)
	private Container container;
	//次级容器,可以用嵌套使用
	private JPanel panel;
	//JPanel类型的数组
	private JPanel[] jPanels;
	
	public CardLayoutTest() {
		//设置窗口的标题
		frame = new JFrame("this is CardLayoutTest");
		//获得容器中的附属容器
		container = frame.getContentPane();
		//设置frame的位置
		frame.setLocation(50,50);
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
		//创建次级容器对象
		panel = new JPanel();
		
		//JFrame默认是BorderLayout布局管理器
		//默认情况就是向中间位置放组件
		container.add(panel);
		
		//创建数组对象
		jPanels = new JPanel[4];
		
		//创建四个JPanel放到数组中并设置背景颜色
		jPanels[0] = new JPanel();
		jPanels[0].setBackground(Color.red);
		
		jPanels[1] = new JPanel();
		jPanels[1].setBackground(Color.blue);
		
		jPanels[2] = new JPanel();
		jPanels[2].setBackground(Color.cyan);
		
		jPanels[3] = new JPanel();
		jPanels[3].setBackground(Color.green);
		
		panel.setLayout(new CardLayout());
		//向CardLayout布局管理器中放置组件的时候一定要给组件起一个名字
		panel.add("0",jPanels[0]);
		panel.add("1",jPanels[1]);
		panel.add("2",jPanels[2]);
		panel.add("3",jPanels[3]);
		
		//添加监听器 可以让鼠标点击之后有反应
		addLister(panel);
		
		
	}
	//addLister这个方法是为了给panel添加一个鼠标点击事件
	private void addLister(final JPanel panel){
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//获得panel容器上面的布局管理器 
				//并转为CardLayout类型的对象
				CardLayout cl = (CardLayout) panel.getLayout();
				//显示CardLayout管理器中的下一个组件
				//这个参数表示:在哪一个容器中设置的这个CardLayout管理器
				cl.next(panel);
//				cl.show(panel, "3");
			}
		
		});
		
	}
	
	
	public static void main(String[] args) {
		
		new CardLayoutTest();
	}
	
}