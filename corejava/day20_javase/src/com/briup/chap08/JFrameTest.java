package com.briup.chap08;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame("JFrame");
		jf.setBounds(200, 100, 300, 300);
		jf.setBackground(Color.CYAN);
		jf.getContentPane().
			setBackground(Color.CYAN);
		jf.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
		
		Button btn = new Button("Button");
		JButton jbtn = new JButton("JButton");
		jf.setLayout(new FlowLayout());
		jf.add(btn);
		jf.add(jbtn);
		
		jf.setVisible(true);
	}
}
