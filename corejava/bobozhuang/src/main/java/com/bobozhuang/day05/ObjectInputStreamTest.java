package com.briup.chap10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream
					(new FileInputStream
						("src/d.txt"));
			Object o = ois.readObject();
			System.out.println
				(o.getClass().getName());
			System.out.println(o);
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
