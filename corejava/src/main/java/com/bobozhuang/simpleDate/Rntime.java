package main.java.com.bobozhuang.simpleDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Rntime {
	public static void main(String[] args) throws Exception {
		String cmd = "cmd /c dir c:\\windows";
		final Process process = Runtime.getRuntime().exec(cmd);
		printMessage(process.getInputStream());
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---");
		printMessage(process.getErrorStream());
		int value = process.waitFor();
		System.out.println(value);
		
	}
	private static void printMessage(final InputStream input){
		new Thread(new Runnable() {
			public void run() {
				if (input == null) {
					System.out.println("this input" + input);
				}
				Reader reader = new InputStreamReader(input);
				BufferedReader bf = new BufferedReader(reader);
				String line = null;
				try {
					while ((line = bf.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
					if (bf == null) {
						try {
							bf.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (reader == null) {
						try {
							reader.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				
			}
		}).start();
		
	}
}
