package main.java.com.bobozhuang.iolearn;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderTest {
	public static void main(String[] args) {

		String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";

		FileReader fr = null;
		
		try {
			
			fr = new FileReader(bbh + "c.txt");
			
//			int v1 = fr.read();
//			System.out.println((char)v1);
//			char[] v2 = new char[64];
//			fr.read(v2);
//			System.out.println
//				(Arrays.toString(v2));
			char[] v2 = new char[4];
			while (fr.read(v2) != -1){
				System.out.println(Arrays.toString(v2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
