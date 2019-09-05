package com.briup.chap07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {
	//假如不知道Student类，内部细节
	// 创建Student对象，并访问Student中的方法和属性
	public static void main(String[] args) 
		throws Exception{
		//1 拿到类的对象
		String name = 
				"com.briup.chap07.Student";
		//Class 代表 把java中的每个类当做一个对象，
		// 抽象总结出来
		// 范围性概念，那么这个类的一个对象，就代表
		// java中的一个类
		Class c = 
				Class.forName(name);
		//查看类中的构造器
		//c.getConstructors();
		Constructor[] cs = 
				c.getDeclaredConstructors();
		//查看构造器的参数列表
		for(Constructor con:cs){
			Class[] pts = 
					con.getParameterTypes();
			for(Class pt:pts){
				System.out.println
					(pt.getName());
			}
			System.out.println("-----");
		}
		
		Object o = cs[1].newInstance
			(101,"李狗蛋",true);
		System.out.println(o);
		
		
		//2 调用类中的方法和属性
		//c.getFields();
		Field[] fs = 
				c.getDeclaredFields();
		for(Field f : fs){
			String type = f.getType()
					.getName();
			int m = f.getModifiers();
			String fn = f.getName();
			System.out.println
				(type+" "+m+" "+fn);
		}
		System.out.println("-------");
		fs[1].setAccessible(true);
		System.out.println(fs[1].get(o));
		fs[1].set(o, "刘村花");
		System.out.println(o);
		//o.name
		// 方法
		//c.getMethods();
		Method[] ms = 
				c.getDeclaredMethods();
		for(Method m : ms){
			int mod = m.getModifiers();
			String rtName = 
					m.getReturnType()
					.getName();
			String mname = m.getName();
			Class[] pts = m.getParameterTypes();
			String str = mod+" "+rtName+" "+mname+"(";
			for(Class pt:pts){
				str+=pt.getName()+",";
			}
			str+=")";
			System.out.println(str);
		}
		System.out.println("--------");
		List l = new ArrayList();
		l.add(1);
		l.add(2);
		l.add(3);
		ms[7].invoke(o, l);
		
		
//		Student s = new Student();
//		s.setName("");
//		s.print(l);
		
	}
}
