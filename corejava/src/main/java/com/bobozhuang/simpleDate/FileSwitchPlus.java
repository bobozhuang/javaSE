package main.java.com.bobozhuang.simpleDate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileSwitchPlus {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String file = null;
		file = in.next();
		if (file.equals("\\n"))
			in.close();
		String strPath = file;
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		String replace = null;
		String replace1s = null;
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				String s1 = strPath + "\\" + fileName;
				replace = s1.replace("\\", "\\\\");
				
				String s3 = strPath+"1";
				replace1s = s3.replace("\\", "\\\\");
				
				switch_1(replace, fileName,replace1s);
			}
			
		}

	}

	public static void switch_1(String replace, String fileName,String replace1s) {
		File replace2 = new File(replace1s);
		if (replace2.exists() != true) {
			try {
				replace2.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		String file1 = replace;
		String file2 = replace1s;
		
		try {

			fr = new FileReader(file1);

			fw = new FileWriter(file2+"\\"+fileName);

			br = new BufferedReader(fr);

			String re = null;
			while ((re = br.readLine()) != null) {
				
				fw.write(re+"\n");
				fw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
					fr.close();
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
