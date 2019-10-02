package com.briup.chap10;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		
		try {
			
			fr = new FileReader("src/day14.txt");
			
			int v1 = fr.read();
			System.out.println((char)v1);
			char[] v2 = new char[64];
			fr.read(v2);
			System.out.println
				(Arrays.toString(v2));
			
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
