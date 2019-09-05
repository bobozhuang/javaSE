package com.briup.chap08;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PokeMoles 
	implements ActionListener{
	//容器
	public JFrame frame;
	//次级容器
	public JPanel northPan;
	public JPanel centerPan;
	//游戏难度
	public JComboBox levels;
	//显示时间
	public JLabel timeInfo;
	public JLabel timeValue;
	//显示分数
	public JLabel scoreInfo;
	public JLabel scoreValue;
	//开始按钮
	public JButton start;
	//地鼠按钮
	public JButton[] moles;
	//控制倒计时
	public Timer time1;
	//控制地鼠出现
	public Timer time2;
	//记录上一次地鼠出现的位置
	public int i;
	//表示地鼠是否被点过
	// false 代表没点过
	// true 代表点过
	public boolean flag = false;
	
	//构造器中初始化容器
	public PokeMoles(){
		frame = new JFrame("打地鼠");
		frame.setSize(400 , 500 );
		Toolkit tool =
				Toolkit.getDefaultToolkit();
		int x = tool.getScreenSize().width;
		int y = tool.getScreenSize().height;
		frame.setLocation((x-400)/2, 
				(y-500)/2);
		frame.setResizable(false);
		frame.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
		//构建次级容器
		northPan = new JPanel();
		centerPan = new JPanel
				(new GridLayout(3, 3));
		//把次级容器放入顶级容器
		frame.add(northPan,
				BorderLayout.NORTH);
		frame.add(centerPan);
		init();
		frame.setVisible(true);
	}
	//init方法中初始化组件
	public void init(){
		//初始化northPan中的组件
		//JComboBox中有addActionListener方法
		//Choice中没有addActionListener方法
		levels = new JComboBox();
		levels.addItem("初级");
		levels.addItem("中级");
		levels.addItem("高级");
		//倒计时
		timeInfo = new JLabel("time:");
		timeValue = new JLabel("10");
		//分数
		scoreInfo = new JLabel(" score:");
		scoreValue = new JLabel("0");
		//开始按钮
		start = new JButton("开始");
		//构建moles
		moles = new JButton[9];
		//使用普通for，循环过程中可以给数组赋值
		//增强for是不行的
		for(int i=0;i<9;i++){
			moles[i] = new JButton();
			//设置地鼠按钮为不可用
			moles[i].setEnabled(false);
			//放到centerPan中
			centerPan.add(moles[i]);
			//给9个按钮添加监听器
			moles[i].addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed         
						(ActionEvent e) {
						JButton btn = (JButton)
								e.getSource();
						if(flag == false
								&&btn.getIcon()!=null){
							int score = Integer.parseInt       
								(scoreValue.getText());
							score++;
							scoreValue.setText(score+"");
							flag = true;
						}
					}
				}
			);
		}
		//向次级容器中添加组件
		northPan.add(levels);
		northPan.add(timeInfo);
		northPan.add(timeValue);
		northPan.add(scoreInfo);
		northPan.add(scoreValue);
		northPan.add(start);
		//添加监听器
		levels.addActionListener(this);
		start.addActionListener(this);
		//初始化计时器
		time1 = new Timer(1000, this);
		time2 = new Timer(1000, this);
		
	}
	public static void main(String[] args) {
		new PokeMoles();
	}
	//因为所有组件的行为都是单击行为
	//所以用一个监听器监听所有的组件就够了
	//通过事件对象获取事件源，判断一下
	//现在产生事件的组件是谁，从而做出不同的处理
	//为了语法匹配，为了好操作
	//我们可能在监听器内要用到各种组件
	//因为我们把组件声明成了属性
	@Override
	public void actionPerformed
		(ActionEvent e) {
		//通过事件对象获取事件源
		//判断事件源 
		Object o = e.getSource();
		//点击开始按钮
		if(o == start){
			//倒计时开始走
			time1.start();
			//把地鼠按钮变成可用
			for(JButton mole:moles){
				mole.setEnabled(true);
			}
			//把开始按钮设置成不可用
			start.setEnabled(false);
			//把上次游戏分数清零
			scoreValue.setText("0");
			//地鼠出现
			time2.start();
		}
		//点击了levels
		else if(o == levels){
			//延迟时间
			int t = 1000;
			String str = (String)
					levels.getSelectedItem();
			if(str.equals("初级")){
				t = 1500;
			}else if(str.equals("中级")){
				t = 1000;
			}else if(str.equals("高级")){
				t = 600;
			}
			time2.setDelay(t);
			
		}
		//进行倒计时
		else if(o == time1){
			String str = 
					timeValue.getText();
			int i = Integer.parseInt(str);
			i--;
			if(i != 0){
				timeValue.setText(i+"");
			}else{
				timeValue.setText(i+"");
				//停止倒计时
				time1.stop();
				//停止地鼠出现
				time2.stop();
				//让start可用
				start.setEnabled(true);
				//地鼠不可用
				for(JButton mole:moles){
					mole.setEnabled(false);
				}
				//重置倒计时时间
				timeValue.setText("10");
				//删除最后一次地鼠
				moles[this.i].setIcon(null);
			}
		}
		//地鼠随机出现
		else if(o == time2){
			//清除上一次地鼠
			moles[i].setIcon(null);
			//重置标识符
			flag = false;
			//随机产生一个下标
			Random r = new Random();
			i = r.nextInt(9);
			//把下标对应的按钮设置上图片
			ImageIcon ii = new ImageIcon
					("src/dishu.jpg");
			moles[i].setIcon(ii);
		}
	}
}
