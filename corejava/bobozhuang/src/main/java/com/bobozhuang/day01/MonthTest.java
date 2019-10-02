package main.java.com.bobozhuang.day01;

public class MonthTest{
	public static void main(String[] args){
		String s = args[0];
		System.out.println(s);
		switch(s){
			case "1":
			case "3":
			case "5":
			case "7":
			case "8":
			case "10":
			case "12":
				System.out.println
					(s+"月 有31天");
				break;
			default:
				System.out.println
					(s+"月 有30天");
				break;
		}
	
	}
}
