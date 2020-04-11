package main.java.com.bobozhuang.iolearn;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 将字符串转为字节数组，将字节数组通过 字节缓冲输出流 输出到文件，文件通过对应的编码就可以看到字符串内容
 */
public class BufferedOutputStreamTest {
	public static void main(String[] args)
			throws Exception {

		String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";

		BufferedOutputStream bos = 
				new BufferedOutputStream
					(new FileOutputStream
						(bbh + "bos.txt"),4);
//		byte[] temp = "你好再见拜".getBytes("GBK");
		byte[] temp = "你好再见拜".getBytes();//当前编码格式为 utf-8
		for(byte b : temp){
			bos.write(b);
		}
		//bos.write(temp);
		bos.flush();
		bos.close();
	}
}
