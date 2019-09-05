package com.briup.ch09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxTest extends JFrame implements ActionListener{
	private static final long serialVersionUID = -2383420372060473853L;
	private Container container;
	private JLabel jLabel;
	private JComboBox<String> box;
	
	public ComboBoxTest() {
		container = getContentPane();
		setBounds(40,40,300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	
	private void init(){
		jLabel = new JLabel("hello world briup");
		box = new JComboBox<String>();
		box.addItem("Dialog");
		box.addItem("DialogInput");
		box.addItem("Monospaced");
		box.addItem("Serif");
		box.addItem("SansSerif");
		
		container.add(jLabel);
		container.add(box,BorderLayout.SOUTH);
		
		box.addActionListener(this);
		
	}
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> jcb = (JComboBox)e.getSource();
		String s = (String)jcb.getSelectedItem();
		Font font = new Font(s,Font.PLAIN,25);
		jLabel.setFont(font);
	}
	
	public static void main(String[] args) {
		new ComboBoxTest();
	}
	
}
