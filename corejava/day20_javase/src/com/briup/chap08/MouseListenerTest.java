package com.briup.chap08;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerTest {
	public JFrame f;
	public JLabel l1;
	public JLabel l2;
	public MouseListenerTest(){
		f = new JFrame();
		f.setBounds(200, 100, 300, 300);
		f.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		init();
		f.setVisible(true);
	}
	public void init(){
		l1 = new JLabel("x = 0.0 ");
		l2 = new JLabel("y = 0.0");
		f.add(l1);
		f.add(l2);
		f.addMouseListener(
			new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					f.getContentPane()
						.setBackground(Color.LIGHT_GRAY);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					f.getContentPane()
						.setBackground(Color.yellow);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			}
		);
		f.addMouseMotionListener(
			new MouseMotionListener() {
				@Override
				public void mouseMoved
					(MouseEvent e) {
					int x = e.getX();
					int y = e.getY();
					l1.setText
						("x="+x+" ");
					l2.setText
						("y="+y+" ");
				}
				@Override
				public void mouseDragged
					(MouseEvent e) {
				}
			}
		);
	}
	public static void main(String[] args) {
		new MouseListenerTest();
	}
}
