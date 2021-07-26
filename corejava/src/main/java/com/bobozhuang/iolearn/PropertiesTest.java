package main.java.com.bobozhuang.iolearn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		//获取classpath的绝对路径
		String path = PropertiesTest.class.getResource("/").toString();
		System.out.println("path = " + path);
//		String fileName = path + "corejava/src/main/java/com/bobozhuang/doc/abcd.properties";
		String fileName = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/doc/abc.properties";
		prop.put("hello", "world");
		//log4j
		prop.load(new FileInputStream(fileName));

		System.out.println(prop.get("name"));
		
		Set<Object> keys = prop.keySet();
		for(Object key : keys){
			System.out.println("key:"+key);
			System.out.println("value:"+prop.get(key));
		}

		//另一种方式读取
		Properties tmpProp = new Properties();
		Properties fp = new Properties();
		InputStream in = tmpProp.getClass().getResourceAsStream(fileName);

		fp.load(in);
		in.close();
		//fp.putAll(tmpProp);
		Set<Object> keyss = fp.keySet();
		for (Object key : keyss){
			System.out.println("key:"+key);
			System.out.println("value:"+prop.get(key));
		}


	}
}




