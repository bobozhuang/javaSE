package com.briup.chap07;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[] args) {
		Map map = new TreeMap(
				new Comparator() {
					@Override
					public int compare
						(Object o1, Object o2) {
						Student s1 = (Student)o1;
						Student s2 = (Student)o2;
						return s1.getId()-s2.getId();
					}
				}
			);
		
		Student s1 = new Student
				(101,"张三",true);
		Student s2 = new Student
				(102,"李四",true);
		Student s3 = new Student
				(103,"王五",false);
		Student s4 = new Student
				(104,"赵六",false);
		
		map.put(s1, 1);
		map.put(s3, 1);
		map.put(s2, 1);
		map.put(s4, 1);
		
		System.out.println
			("map中元素个数:"+map.size());
		
//		System.out.println
//			(map.containsKey(true));
		
		System.out.println
			("map中元素个数:"+map.size());
		//遍历map
		Set set = map.keySet();
		Iterator site = set.iterator();
		while(site.hasNext()){
			Object key = site.next();
			Object value = map.get(key);
			System.out.println
				(key+" = "+value);
		}
		System.out.println("--------");
		Set kvs = map.entrySet();
		Iterator kvite = kvs.iterator();
		while(kvite.hasNext()){
			Map.Entry kv = 
				(Map.Entry)kvite.next();
			Object key = kv.getKey();
			Object value = kv.getValue();
			System.out.println
				(key+" = "+value);
		}
		System.out.println("-----");
		Collection values = map.values();
		for(Object value:values){
			System.out.println
				("value:"+value);
		}
	}
}
