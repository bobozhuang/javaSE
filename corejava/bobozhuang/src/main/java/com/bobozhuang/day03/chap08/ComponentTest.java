
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentTest {
	public JFrame frame;
	public JButton btn;
	//文本域
	public JTextArea ta;
	//文本框
	public JTextField tf;
	//下拉列表
	public Choice cho;
	public JComboBox jcb;
	//列表
	public List l;
	public JList jl;
	//多选按钮
	public Checkbox cb;
	public JCheckBox cb2;
	//菜单
	public Menu m1;
	public JMenu m2;
	
	public ComponentTest(){
		frame = new JFrame();
		Toolkit tool = 
				Toolkit.getDefaultToolkit();
		int x = tool.getScreenSize().width;
		int y = tool.getScreenSize().height;
		frame.setBounds
			((x-400)/2, (y-400)/2, 400, 400);
		frame.setDefaultCloseOperation
			(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		MenuBar mb = new MenuBar();
		Menu m1 = new Menu("开始");
		m1.add("打开");
		m1.add("保存");
		m1.add("另存为");
		Menu m2 = new Menu("帮助");
		m2.add("版权信息");
		m2.add("属性");
		mb.add(m1);
		mb.add(m2);
		frame.setMenuBar(mb);
		//初始化容器
		init();
		frame.setVisible(true);
	}
	public void init(){
		//初始化组件
//		btn = new JButton();
//		Icon i = new ImageIcon("src/1.jpg");
//		btn.setIcon(i);
//		frame.add(btn);
//		
//		ta = new JTextArea();
//		ta.setText("窗前明月光，疑是地上霜");
//		Font f = new Font
//				("楷体", 
//				Font.CENTER_BASELINE,
//				30);
//		ta.setFont(f);
//		ta.setForeground(Color.red);
//		frame.add(ta);
//		
//		tf = new JTextField("hello world");
//		tf.setSize(100, 20);
//		frame.add(tf);
//		
//		jcb = new JComboBox();
//		jcb.addItem("省份");
//		jcb.addItem("山西");
//		jcb.addItem("江苏");
//		jcb.addItem("山东");
//		frame.add(jcb);
//		
//		l = new List();
//		l.add("hello");
//		l.add("world");
//		l.add("briup");
//		frame.add(l);
//		
//		cb2 = new JCheckBox("香蕉");
//		frame.add(cb2);
		
		JColorChooser jcc =
				new JColorChooser();
		frame.add(jcc);
		
		JLabel jll = new JLabel("你好~");
		frame.add(jll);
		
	}
	public static void main(String[] args) {
		new ComponentTest();
	}
}
