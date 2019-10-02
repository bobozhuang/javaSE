import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest1 {
	public static void main(String[] args) {
		// java.awt.*   javax.swing.*
		
		//1 获取容器
		Frame f = new Frame("测试框体");
		Dialog d = new Dialog(f);
		FileDialog fd = new FileDialog(f,"文件选择");
		//2 设置容器 
		f.setSize(200, 200);
		f.setLocation(200, 100);
		//颜色的使用方式
		// Color  
		f.setBackground(Color.PINK);
		//3 添加组件(设置组件)
		Panel p = new Panel();
		Button btn = new Button("测试");
		p.add(btn);
		f.add(p);
		//*4 添加监听器
		f.addWindowListener(
			new WindowAdapter() {
				@Override
				public void windowClosing
					(WindowEvent e) {
					System.exit(0);
				}
			}
		);
		
		//5 设置可见性
//		d.setVisible(true);
//		fd.setVisible(true);
		f.setVisible(true);
	}
}
