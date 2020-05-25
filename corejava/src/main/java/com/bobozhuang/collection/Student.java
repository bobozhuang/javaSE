package main.java.com.bobozhuang.collection;

import java.util.List;

public class Student implements Comparable {
	private int id;
	private String name;
	private boolean gender;

	public Student() {
	}

	public Student(int id, String name, boolean gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int hashCode() {
		return this.id;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Student)) {
			return false;
		}
		if (this == o) {
			return true;
		}
		Student s = (Student) o;
		if (this.id == s.id && this.name.equals(s.name)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		// if(this.id > s.id){
		// return 1;
		// }else if(this.id < s.id){
		// return -1;
		// }else{
		// return 0;
		// }

		return -(this.id - s.getId());
	}
	// 把泛型类作为参数时
	// 可以使用一个 ? 作为通配符

	public void print(List<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

	public void print1(List<? extends Teacher> list) {

	}

	public void print2
		(List<? super Teacher> list) {

	}

	public void print3(List<Object> l){
		
	}
	
	
	
}
