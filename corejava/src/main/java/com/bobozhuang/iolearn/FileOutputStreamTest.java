package main.java.com.bobozhuang.iolearn;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) 
		throws IOException{

		String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";

		FileOutputStream fos = 
				new FileOutputStream
					(bbh + "file.txt",true);
		
		byte[] b = "你好中国".getBytes();
		System.out.println(b.length);
		fos.write(b);//会在原来的内容之后追加
		
		fos.flush();
		fos.close();
	}
}

