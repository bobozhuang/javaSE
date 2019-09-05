package com.briup.chap08;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.scene.layout.Border;

public class KeyListenerTest {
	public JFrame f;
	public JTextArea ta;
	public JTextField tf;
	
	public KeyListenerTest() {
		f = new JFrame("聊天窗口");
		f.setBounds(200, 100, 300, 300);
		f.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
		//f.setLayout(new FlowLayout());
		init();
		f.setVisible(true);
	}
	public void init(){
		ta = new JTextArea();
		tf = new JTextField();
		
		f.add(ta, BorderLayout.CENTER);
		f.add(tf, BorderLayout.SOUTH);
		
		tf.addKeyListener(
			new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					int code = e.getKeyCode();
					System.out.println(code);
					if(code == KeyEvent.VK_ENTER){
						String str = tf.getText();
						ta.setText
							(ta.getText()
									+"\n"+str);
						tf.setText("");
					}
				}
			}
		);
	}
	public static void main(String[] args) {
		new KeyListenerTest();
	}
}
