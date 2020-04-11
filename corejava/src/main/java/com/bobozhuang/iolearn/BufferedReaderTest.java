package main.java.com.bobozhuang.iolearn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class BufferedReaderTest {
	public static void main(String[] args)
		throws Exception{
		String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";
		String encoding = System.getProperty("file.encoding");
		Properties properties = System.getProperties();
		System.out.println(encoding);

		//如果不考虑编码问题
		//可以这么构建
		BufferedReader in1 =
				new BufferedReader
					(new FileReader
						(bbh + "/file.txt"));

		BufferedReader in = 
				new BufferedReader
					(new InputStreamReader
						(new FileInputStream(bbh + "/file.txt"),
								encoding));
		
		
		String str = in.readLine();
		System.out.println(str);
		String str1 = in1.readLine();
		System.out.println(str1);
		in.close();
		in1.close();
	}
}
