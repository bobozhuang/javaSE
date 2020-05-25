package main.java.com.bobozhuang.collection;

import java.util.ArrayList;
import java.util.List;


public class GenericTest {
	// 泛型只能用在集合中
	// 约束集合内部元素的数据类型
	// 在编译过程中检查类型是否匹配
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Student
				(101,"张三",true));
		Student s = (Student)list.get(0);
		
		List<Student> ss =
				new ArrayList<>();


		ss.add(new Student(101, "张三", true));
		ss.add(new Student(102,"李四",false));
		
		Student stu = ss.get(0);
		
		//The method print1(List<? extends Teacher>) in the type Student 
		//is not applicable for the arguments (List<Date>)
		List<MathTeacher> l = 
				new ArrayList<MathTeacher>();
		stu.print1(l);
		
		List<Teacher> l2 = 
				new ArrayList<Teacher>();
		stu.print2(l2);
		
		List<?> l3 = new ArrayList<Teacher>();
		
		//stu.print3(l3);
		
	}
}
