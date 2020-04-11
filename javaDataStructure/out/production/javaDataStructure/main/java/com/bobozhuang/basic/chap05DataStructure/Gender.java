package main.java.com.bobozhuang.day03.chap07;


public enum Gender{
	//有限个数的对象列在类中
	// Gender MALE = new Gender();
	MALE("男"){
		@Override
		public void looklike() {
			System.out.println("有胡子");
		}
	},
	FEMALE("女"){
		@Override
		public void looklike() {
			System.out.println("没胡子");
		}
	}
	;
	//属性  方法
	private String name;

	private Gender(){
		
	}
	
	private Gender(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello(){
		System.out.println("hello");
	}

	public abstract void looklike();
	
}
