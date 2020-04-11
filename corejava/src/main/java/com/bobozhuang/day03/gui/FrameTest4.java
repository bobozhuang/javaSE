import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest4 {
	public static void main(String[] args) {
		Frame f = new Frame("GridLayout");
		f.setBounds(200, 100, 300, 300);
		
		f.setLayout(new GridLayout(4,5));
		
		for(int i=1;i<=25;i++){
			f.add(new Button(i+""));
		}
		
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
