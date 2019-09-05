package com.briup.chap10;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamTest {
	public static void main(String[] args)
			throws Exception {
		BufferedOutputStream bos = 
				new BufferedOutputStream
					(new FileOutputStream
						("src/b.txt"),4);
		byte[] temp = "你好再见拜".getBytes();
		for(byte b : temp){
			bos.write(b);
		}
		//bos.write(temp);
		bos.flush();
		bos.close();
	}
}
