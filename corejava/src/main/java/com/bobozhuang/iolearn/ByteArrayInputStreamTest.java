package main.java.com.bobozhuang.iolearn;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayInputStreamTest {
	public static void main(String[] args) {
		byte[] b = "程序的主序".getBytes();
		byte[] c = {-25, -88, -117, -27, -70};
		System.out.println
				(Arrays.toString(c));
		ByteArrayInputStream bis = null;
		try {
			bis = new ByteArrayInputStream(b); 
			byte[] temp = new byte[5];
			while(bis.read(temp) != -1){
				System.out.println
					(Arrays.toString(temp));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
