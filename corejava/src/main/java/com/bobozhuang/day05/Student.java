import java.io.Serializable;

public class Student 
	implements Serializable{
//	private static final long 
//		serialVersionUID = 110435894040108943L;
	private int id;
	transient private String name;
	private int age;
	private double d;
	public Student() {
	}
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id 
				+ ", name=" + name 
				+ ", age=" + age + "]";
	}
	
}


