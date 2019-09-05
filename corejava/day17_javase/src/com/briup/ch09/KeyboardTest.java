package com.briup.ch09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyboardTest extends JFrame{
	private static final long serialVersionUID = 4283324412525912842L;
	private Container container;
	private JPanel jPanel;
	//滚动条
	private JScrollPane scroll;
	//文本域
	private JTextArea area;
	private JTextField textField;
	public KeyboardTest(String title){
		setTitle(title);
		//获得当前屏幕的宽和高
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		//把窗口设置在屏幕中间
		setLocation((width-500) / 2, (height-500) / 2 );
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	private void init(){
		
		container = getContentPane();
		jPanel = new JPanel();
		area = new JTextArea();
		
		//把需要加滚动条的文本域设置进来
		scroll = new JScrollPane(area); 
		textField = new JTextField();
		
		container.setLayout(new BorderLayout());
		jPanel.setLayout(new BorderLayout());
		
		//设置文本域不可编辑
		area.setEditable(false);
		//设置文本域内自动换行
		area.setLineWrap(true); 
		//设置文本域背景颜色
		area.setBackground(Color.lightGray);
		
		
		jPanel.add(scroll);
		container.add(jPanel);
		container.add(textField, BorderLayout.SOUTH);
		
		textField.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				//获得按键的keyCode值
				int keyCode = e.getKeyCode();
				//获得输入框中的内容
				String str = textField.getText();
				//如果按了回车
				if(keyCode == 10 && !"".equals(str.trim())){
					area.append(str+"\n");
					textField.setText("");
				}
			}
		});
		
	}
	public static void main(String[] args){
		new KeyboardTest("KeyboardTest Test");
	}
}
