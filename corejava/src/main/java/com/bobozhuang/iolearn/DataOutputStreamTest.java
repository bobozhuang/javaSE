package main.java.com.bobozhuang.iolearn;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {
	public static void main(String[] args) {
		String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";

		DataOutputStream dos = null;
		try{
			dos = new DataOutputStream
					(new FileOutputStream
						(bbh + "a.txt"));
			dos.writeInt(100);
			dos.writeDouble(3.14);
			dos.writeChar('中');
			dos.writeUTF("山西大学");
			
			dos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(dos != null){
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
