package com.briup.chap10;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterTest {
	public static void main(String[] args) 
		throws Exception{
		
		PrintWriter out = 
				new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream
								("src/day14.txt.gbk")
								,"GBK"));
		out.println("进程是指运行中的应用程序");
		out.println("每一个进程都有自己独立的内存空间。");
		
		out.flush();
		out.close();
	}
	
}
