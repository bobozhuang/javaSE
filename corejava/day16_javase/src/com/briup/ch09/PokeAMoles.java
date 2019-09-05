package com.briup.ch09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PokeAMoles implements ActionListener{
	//窗口
	private JFrame frame;
	//次级容器
	private Container con;
	//做区域划分
	private JPanel northPanel,centerPanel;
	//在northPanle
	private JComboBox<String> levels;
	private JLabel timeInfo,timeValue,scoreInfo,scoreValue;
	private JButton startBtn;
	//centerPanel
	private JButton[] moles;
	//倒计时
	private Timer time1;
	//控制地鼠出现
	private Timer time2;
	// 记录地鼠出现的位置
	private int lastLoaction;
	//代表地鼠是否被打过 false 代表没打过 
	private boolean flag;
	//游戏难度
	private int t = 2000;
	public PokeAMoles(){
		frame = new JFrame("打地鼠");
		frame.setSize(500, 500);
		//把窗体放在屏幕正中间
		int width = Toolkit.getDefaultToolkit()
				.getScreenSize().width;
		int height = Toolkit.getDefaultToolkit()
				.getScreenSize().height;
		frame.setLocation
			((width-500)/2, (height-500)/2);
		frame.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
		//窗体大小固定
		frame.setResizable(false);
		init();
		frame.setVisible(true);
		
	}
	// 窗体内组件的初始化
	private void init() {
		//次级容器
		con = frame.getContentPane();
		//初始化北边的panel
		northPanel = new JPanel();
		//布局方式
		northPanel.setLayout(new FlowLayout());
		//初始化中心panel
		centerPanel = new JPanel();
		//中心panel 布局方式
		centerPanel.setLayout(new GridLayout(3, 3));
		levels = new JComboBox<String>();
		levels.addItem("初级");
		levels.addItem("中级");
		levels.addItem("高级");
		//初始化label
		timeInfo = new JLabel("time:");
		timeValue = new JLabel("10");
		scoreInfo = new JLabel(" score:");
		scoreValue = new JLabel("0");
		//开始按钮
		startBtn = new JButton("start");
		
		// btn[]
		moles = new JButton[9];
		//普通for ，增强for 不能给数组每一个元素赋值
		for (int i=0;i<moles.length;i++) {
			moles[i] = new JButton();
			centerPanel.add(moles[i]);
			//初始化界面后，地鼠不能打
			moles[i].setEnabled(false);
		}
		
		
		//把其他组件放到northPanel
		northPanel.add(levels);
		northPanel.add(timeInfo);
		northPanel.add(timeValue);
		northPanel.add(scoreInfo);
		northPanel.add(scoreValue);
		northPanel.add(startBtn);
		//把两个panel
		con.add(northPanel,BorderLayout.NORTH);
		con.add(centerPanel);
		//添加监听器
		startBtn.addActionListener(this);
		time1 = new Timer(1000, this);
		time2 = new Timer(t, this);
		levels.addActionListener(this);
		//给地鼠添加监听器
		for (JButton mole : moles) {
			mole.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//有图标的按钮才给加分
					if(flag==false&&mole.getIcon()!=null){
						int score = Integer.parseInt
							(scoreValue.getText());
						score++;
						scoreValue.setText(score+"");
						//把地鼠变成已经点过的
						flag = true;
					}
				}
			});
		}
	}
	public static void main(String[] args) {
		new PokeAMoles();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//获得事件源，方便做判断
		Object source = e.getSource();
		//开始按钮做的事情
		if(source == startBtn){
			//开始倒计时
			time1.start();
			//开始地鼠出现
			time2.start();
			startBtn.setEnabled(false);
			for (JButton mole : moles) {
				mole.setEnabled(true);
			}
			//分数清零
			scoreValue.setText("0");
			//禁用游戏难度
			levels.setEnabled(false);
		}
		//计时器time1做的事情
		else if(source == time1){
			//获取时间值
			String str = timeValue.getText();
			//字符串转化成基本数据类型
			int i = Integer.parseInt(str);
			i--;
			timeValue.setText(i+"");
			if(i==0){
				time1.stop();
				//时间结束，地鼠回归不能点的状态
				for (JButton mole : moles) {
					mole.setEnabled(false);
				}
				//倒计时结束，清除最后一个地鼠
				moles[lastLoaction].setIcon(null);
				//start可以点
				startBtn.setEnabled(true);
				//倒计时重置
				timeValue.setText(10+"");
				
				//地鼠结束出现
				time2.stop();
				//游戏难度可用
				levels.setEnabled(true);
			}
		}
		//控制地鼠出现
		else if(source == time2){
			//1 把页面清空
			//2 记录上次地鼠出现的位置
			moles[lastLoaction].setIcon(null);
			//[0,1)     [0,8]
			int i = (int)(Math.random()*9);
			moles[i].setIcon(
					new ImageIcon("src/mouse.jpg"));
			//记录每次地鼠出现的位置
			lastLoaction = i;
			//初始化标识为false 代表新出现的地鼠没被打过
			flag = false;
		}
		//调节游戏难度
		else if(source == levels){
			String level = 
					(String)levels.getSelectedItem();
			if(level.equals("初级")){
				t = 2000;
			}else if(level.equals("中级")){
				t = 1000;
			}else if(level.equals("高级")){
				t = 500;
			}
			time2.setDelay(t);
		}
		
	}
}




