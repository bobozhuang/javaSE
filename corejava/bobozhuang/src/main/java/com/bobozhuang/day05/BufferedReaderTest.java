package com.briup.chap10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class BufferedReaderTest {
	public static void main(String[] args)
		throws Exception{
		//如果不考虑编码问题
		//可以这么构建
//		BufferedReader in = 
//				new BufferedReader
//					(new FileReader
//						("src/day14.txt.gbk"));
		BufferedReader in = 
				new BufferedReader
					(new InputStreamReader
						(new FileInputStream("src/day14.txt.gbk"),
							"GBK"));
		
		
		String str = in.readLine();
		System.out.println(str);
		
		in.close();
	}
}
