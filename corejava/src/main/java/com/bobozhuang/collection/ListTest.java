package main.java.com.bobozhuang.collection;

import main.java.com.bobozhuang.day02.Pig;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class ListTest {
	//存放有序 （放入集合的顺序，和取出来的顺序是一致的）
	//可重复 的引用类型的值
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		List list = 
				new Vector();
		//添加元素
		list.add(100);
		list.add(3.14);
		list.add(new String("hello"));
		list.add(new Pig());
		list.add(new int[4]);
		list.add(100);
		list.add(3.14);
		//集合长度
		System.out.println
			("list中元素个数:"+list.size());
		//删除元素
		list.remove(3.14);
		System.out.println
			("list中元素个数:"+list.size());
		list.remove(3);
		System.out.println
			("list中元素个数:"+list.size());
		//使用迭代器遍历集合
		System.out.println("-------");
		Iterator ite = list.iterator();
		while(ite.hasNext()){
			Object o = ite.next();
			System.out.println(o);
		}
		System.out.println("-------");
		//查看是否包含某个值
		System.out.println
			(list.contains(100));
		//清空集合
		list.clear();
		System.out.println
			("list中元素个数:"+list.size());
//		for(int i = 0;i < 10000000;i++){
//			list.add(i);
//		}
		long time2 = System.currentTimeMillis();
		System.out.println(time2-time1);
	}
}



