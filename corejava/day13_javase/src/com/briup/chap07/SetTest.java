package com.briup.chap07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	//无序，不可重复的数据
	public static void main(String[] args) {
		Set set = new HashSet();
		Student s1 = new Student(101,"张三",true);
		Student s2 = new Student(101,"李四",true);
		Student s3 = new Student(101,"张三",false);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println
			("set集合中元素个数:"+set.size());
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			Object o = ite.next();
			System.out.println(o);
		}
		
	}
}
