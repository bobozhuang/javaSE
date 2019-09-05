package com.briup.ch08;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MyFirstGUI {
	//顶级容器(窗口)
	private JFrame frame;
	//次级容器
	private Container container;
	//按钮
	private JButton button;
	//Label标签
	private JLabel addLabel,eqsLabel;
	//文本输入框
	private JTextField f1,f2,f3;
	
	public MyFirstGUI() {
		//初始化容器(相当于桌子)
		frame = new JFrame();
		//获得次级容器对象(相当于桌布)
		container = frame.getContentPane();
		//参数1和2是设置frame的位置,电脑屏幕左上角为(0,0)坐标
		//参数3和4指的是frame显示的大小(长宽)
		frame.setBounds(40, 40, 400, 400);
		//点击界面右上角红叉可以关闭程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//相当于设置界面的标题在界面的上边界里面
		frame.setTitle("this is my first GUI");
		init();
		//设置界面可以显示,默认容器初始化完成之后是隐藏的
		frame.setVisible(true);
	}
	
	private void init(){
		//初始化组件
		button = new JButton("add");
		addLabel = new JLabel("+");
		eqsLabel = new JLabel("=");
		//创建文本输入框对象,并设置长度为5
		f1 = new JTextField(5);
		f2 = new JTextField(5);
		f3 = new JTextField(5);
		
		//设置容器的布局管理器
		container.setLayout(new FlowLayout());
		
		//把组件添加到容器当中
		container.add(f1);
		container.add(addLabel);
		container.add(f2);
		container.add(eqsLabel);
		container.add(f3);
		container.add(button);
		
		//给指定的组件添加事件监听
		button.addActionListener(new ActionListener(){
			//当鼠标点击这个指定按钮的时候程序就会调用这个方法
			@Override
			public void actionPerformed(ActionEvent e) {
				//拿到第一个输入框中的数组(String转换为Double)
				double a = 
					Double.parseDouble(f1.getText());
				
				//拿到第二个输入框中的数组(String转换为Double)
				double b = 
					Double.parseDouble(f2.getText());
				
				//相加得到结果
				double c = a+b;
				//把结果放到第三个输入框中
				f3.setText(c+"");
			}
		});
	}
	
	public static void main(String[] args) {
		new MyFirstGUI();
	}
	
	
}