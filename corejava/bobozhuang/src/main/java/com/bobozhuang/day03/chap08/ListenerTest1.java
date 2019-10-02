

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListenerTest1 {
	public JFrame f;
	public JButton btn;
	
	public ListenerTest1(){
		f = new JFrame();
		f.setBounds(200, 100, 300, 300);
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
		init();
		f.setVisible(true);
	}
	public void init(){
		btn = new JButton("改变颜色");
		f.add(btn);
		//给按钮添加监听器
		btn.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed
					(ActionEvent e) {
					Color c = new Color
							((float)Math.random(),
							(float)Math.random(),
							(float)Math.random());
					f.getContentPane().
						setBackground(c);
				}
			}
		);
	}
	public static void main(String[] args) {
		new ListenerTest1();
	}
	
}
