package main.java.com.bobozhuang.iolearn;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) 
			throws IOException {
		String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";

		//  \\
		// /User/zhaojing/....
		// D:\\....\\
		FileInputStream fis = 
				new FileInputStream
					(bbh + "file.txt");
		///Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/day05/day14.txt
		//main/java/com/bobozhuang/day05/day14.txt
		///Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/day05/day14.txt
		byte[] b = new byte[30];
		StringBuilder sb = new StringBuilder();
		while(fis.read(b)!=-1){
			System.out.println
				(new String(b));
			sb.append("s");
		}
		
		fis.close();
	}
}
