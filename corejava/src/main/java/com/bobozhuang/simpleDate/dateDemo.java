package main.java.com.bobozhuang.simpleDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class dateDemo {

	private static String pwd12341;

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String g = sdf.format(date);
		System.out.println(sdf);
		System.out.println(sdf.format(date));

	/*	List<String> ls = new ArrayList<>();
		String[] arg = new String[] { "cmd", "dir"};
		String cmd = "cmd dir";
		Process proc = null;
		BufferedReader in = null;
		try {
			proc = Runtime.getRuntime().exec(cmd);
			in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				ls.add(line); // �����ж��Ƿ�ִ�гɹ�
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (proc != null) {
				try {
					proc.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		System.out.println(ls);
	*/
	}
}
