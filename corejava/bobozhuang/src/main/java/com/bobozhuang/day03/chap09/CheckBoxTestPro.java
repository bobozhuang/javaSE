package com.briup.ch09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxTestPro extends JFrame implements ActionListener{
	private static final long serialVersionUID = 5584068990694867522L;
	private Container container;
	private JLabel label;
	private JCheckBox box1,box2;
	private JPanel panel;
	private boolean box1_flag;
	private boolean box2_flag;
	
	public CheckBoxTestPro() {
		container = getContentPane();
		setBounds(40,40,300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	
	private void init(){
		label = new JLabel("briup hello world");
		Font font = new Font("SansSerif",Font.PLAIN,25);
		label.setFont(font);
		
		panel = new JPanel();
		box1 = new JCheckBox("BOLD");
		box2 = new JCheckBox("ITALIC");
		
		panel.add(box1);
		panel.add(box2);
		
		container.add(label);
		container.add(panel,BorderLayout.SOUTH);
		
		//本来参数应该是一个ActionListener接口实现类对象
		//一般我们会写一个ActionListener接口的匿名内部类对象放在这
		//我们这里能写this的原因是:当前类CheckBoxTestPro实现了ActionListener
		//所以当前类CheckBoxTestPro就是ActionListener接口的一个实现类
		//ActionListener a = new CheckBoxTestPro();
		//我们就可以把a当做一个监听器使用
		//this代表当前类CheckBoxTestPro的一个对象(也可以当做一个监听器使用)
		//所以我们在这里可以直接写this
		box1.addActionListener(this);
		box2.addActionListener(this);
		
		/*box1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		box2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});*/
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(box1==o){
			Font font = null;
			if(!box1_flag){
				font = new Font("SansSerif",Font.BOLD,25);
			}else{
				font = new Font("SansSerif",Font.PLAIN,25);
			}
			label.setFont(font);
			box1_flag = !box1_flag;
		}
		if(box2==o){
			Font font = null;
			if(!box2_flag){
				font = new Font("SansSerif",Font.ITALIC,25);
			}else{
				font = new Font("SansSerif",Font.PLAIN,25);
			}
			label.setFont(font);
			box2_flag = !box2_flag;
		}
		
	}
	
	public static void main(String[] args) {
		new CheckBoxTestPro();
	}
	
}
