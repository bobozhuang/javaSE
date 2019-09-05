package com.briup.chap08;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import javafx.scene.layout.Border;

public class TimerTest {
	public JFrame f;
	public Timer t;
	public JLabel l;
	public JButton btn;
	public TimerTest() {
		f = new JFrame("倒计时");
		f.setBounds(200, 100, 300, 300);
		f.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
		//f.setLayout(new FlowLayout());
		init();
		f.setVisible(true);
	}
	public void init() {
		l = new JLabel("10");
		btn = new JButton("start");
		f.add(l,BorderLayout.CENTER);
		f.add(btn, BorderLayout.NORTH);
		t = new Timer(1000, 
			new ActionListener() {
				@Override
				public void actionPerformed
					(ActionEvent e) {
					String str = l.getText();
					int i = Integer.parseInt(str);
					if(i>0){
						i--;
						l.setText(i+"");
					}else{
						t.stop();
					}
				}
			}
		);
		
		btn.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed
					(ActionEvent e) {
					t.start();
				}
			}
		);
	}
	public static void main(String[] args) {
		new TimerTest();
	}
}
