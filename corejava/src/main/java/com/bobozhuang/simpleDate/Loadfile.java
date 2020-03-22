package main.java.com.bobozhuang.simpleDate;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.transform.SourceLocator;

public class Loadfile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String filename = "C:\\Users\\csii_huangfurh\\Desktop\\Work\\20180308\\application_dev.properties"; 
		Properties p = new Properties();
		InputStream is = new FileInputStream(new File(filename));
		p.load(is);
		System.out.println(p);
		load_1();
	}
	public static void load_1() throws Exception{
		//String filename = "C:\\Users\\csii_huangfurh\\Desktop\\Work\\20180308\\application_dev.properties"; 
		Properties p = new Properties();
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getSystemResourceAsStream("application_dev.properties");
		InputStream iss = ClassLoader.getSystemResourceAsStream("application_dev.properties");
		InputStream isss = SourceLocator.class.getClassLoader().getSystemResourceAsStream("application_dev.properties");
		p.load(iss);
		System.out.println(p);
	}
	public static void load_2(){
		
	}
}
