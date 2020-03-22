package main.java.com.bobozhuang.simpleDate;

public class StrDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12312,";
		String st = null;
		String[] strings = st.split(",");
		for (int i = 0; i < strings.length; i++) {
			System.out.println("===" + strings[i] + "----" + i);
		}
		
		
		String[] is = s.split(",");
		System.out.println(s);
		for (int i = 0; i < is.length; i++) {
			System.out.println("===" + is[i] + "----" + i);
		}
		
	}

}
