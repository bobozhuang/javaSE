package main.java.com.bobozhuang.day03.chap07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	//���򣬲����ظ�������
	public static void main(String[] args) {
		Set set = new HashSet();
		Student s1 = new Student(101,"����",true);
		Student s2 = new Student(101,"����",true);
		Student s3 = new Student(101,"����",false);

		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(null);
		System.out.println
			("set������Ԫ�ظ���:"+set.size());
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			Object o = ite.next();

			System.out.println(o);
//			if (null == o)
//			set.remove(o);
		}
		System.out.println("----" + set.toString());
		while (ite.hasNext()) {
			Object o = ite.next();

			System.out.println(o);

		}
		try {
			int a = 8/0;
		}catch (Exception e){
			System.out.println("aaa");
		}

		System.out.println("----");

		String s = "asdff";
		System.out.println(s);
		String substring = s.substring(0, 8);
		System.out.println(substring);


	}
}
