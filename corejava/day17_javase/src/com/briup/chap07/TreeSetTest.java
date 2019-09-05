package com.briup.chap07;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Set set = new TreeSet(
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
//		set.add(8);
//		set.add(4);
//		set.add(3);
//		set.add(9);
//		set.add(6);
//		set.add(7);
//		set.add(1);
//		set.add(2);
		
//		set.add('b');
//		set.add('d');
//		set.add('a');
//		set.add('c');
//		set.add('e');
		
		set.add(new Student
				(101, "张三", true));
		set.add(new Student
				(102, "李四", true));
		set.add(new Student
				(103, "王五", true));
		set.add(new Student
				(104, "赵六", true));
		
		
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			Object o = 
					ite.next();
			set.remove(o);
			//ite.remove();
			System.out.println(o);
		}
		
//		for(Object o : set){
//			set.add(new Student(10, "zs", true));
//			System.out.println(o);
//		}
		
		for(Iterator it = set.iterator()
				; it.hasNext()  ;  ){
			Object o = it.next();
			
		}
		
		
		
	}
}
