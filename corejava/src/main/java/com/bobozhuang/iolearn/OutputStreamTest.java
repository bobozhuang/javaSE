package main.java.com.bobozhuang.iolearn;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {
	public static void main(String[] args) 
			throws IOException {
		OutputStream out = System.out;
		out.write(97);
		out.write(10);
		byte[] b = "helloworld".getBytes();
		out.write(b);
		out.write(10);
		out.write(b, 3, 5);
		
		out.flush();
		out.close();
	}
}


