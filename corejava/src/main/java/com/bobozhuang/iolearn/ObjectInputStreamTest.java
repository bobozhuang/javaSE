package main.java.com.bobozhuang.iolearn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {
	public static void main(String[] args) {

		String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream
					(new FileInputStream
						(bbh + "obj.txt"));
			Object o = ois.readObject();
			System.out.println
				(o.getClass().getName());
			System.out.println(o.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ois != null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
