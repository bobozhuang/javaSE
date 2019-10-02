package com.briup.chap10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {
	public static void main(String[] args) {
		//String s = new String("helloworld");
		Student s = new Student
				(10	,"张三", 30);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream
					(new FileOutputStream
						("src/d.txt"));
			oos.writeObject(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos != null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


