package main.java.com.bobozhuang.day03.chap08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest2 {
	public static void main(String[] args) {
		//布局方式
		//BorderLayout
		//FlowLayout
		//GridLayout
		//CardLayout
		Frame f = new Frame("BorderLayout");
		f.setBounds(200, 100, 300, 300);
		
		Button s_btn = new Button("South");
		Button n_btn = new Button("North");
		Button w_btn = new Button("West");
		Button e_btn = new Button("East");
		Button c_btn = new Button("Center");
		
		f.add(s_btn,
				BorderLayout.SOUTH);
		//f.add(n_btn, 
		//		BorderLayout.NORTH);
		f.add(w_btn, 
				BorderLayout.WEST);
		//f.add(e_btn, 
		//		BorderLayout.EAST);
		f.add(c_btn, 
				BorderLayout.CENTER);
		f.addWindowListener(
				new WindowAdapter() {
					@Override
					public void windowClosing
						(WindowEvent e) {
						System.exit(0);
					}
				}
		);
		
		f.setVisible(true);
	}
}
