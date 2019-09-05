package com.briup.ch09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseTest1 {
	private JFrame frame;
	private Container con;
	private JButton btn;
	
	public MouseTest1(){
		frame = new JFrame("test");
		frame.setBounds(200, 200, 300, 300);
		//frame.setBackground(Color.BLUE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		frame.setVisible(true);
	}

	private void init() {
		con = frame.getContentPane();
		con.setBackground(Color.BLUE);
		btn = new JButton("Change Color");
		con.add(btn, BorderLayout.NORTH);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float d1 = (float)Math.random();
				float d2 = (float)Math.random();
				Float d3 = (float)Math.random();
				Color color = new Color(d1, d2, d3);
				con.setBackground(color);
//				
//				Dialog d = new Dialog(frame);
//				d.addWindowListener(new WindowAdapter() {
//
//					@Override
//					public void windowClosing(WindowEvent e) {
//						System.exit(0);
//					}
//					
//				});
//				d.setBounds(100, 100, 150, 150);
//				Label l = new Label();
//				l.setFont(new Font("黑体", Font.ITALIC, 20));
//				l.setText("这是一个弹框");
//				d.add(l);
//				d.setVisible(true);
			}
		});
		
	}
	public static void main(String[] args) {
		new MouseTest1();
	}
	
}
