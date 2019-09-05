package com.briup.chap10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		Properties prop = 
				new Properties();
		prop.put("hello", "world");
		//log4j
		prop.load
			(new FileInputStream
				("src/abc.properties"));
		
		System.out.println(prop.get("name"));
		
		Set<Object> keys = prop.keySet();
		for(Object key : keys){
			System.out.println("key:"+key);
			System.out.println("value:"+prop.get(key));
		}
		
	}
}




