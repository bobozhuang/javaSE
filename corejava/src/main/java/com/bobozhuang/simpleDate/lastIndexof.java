package main.java.com.bobozhuang.simpleDate;

public class lastIndexof {
	public static void main(String[] args) {
		String s = "zxcvb.sh";
		System.out.println(s.lastIndexOf("."));
		System.out.println(s.lastIndexOf(".")+1);
		System.out.println(s.substring(s.lastIndexOf(".")));
		
		String prefix = s.substring(s.lastIndexOf(".") + 1);//txt
		String custName = System.currentTimeMillis() + "." + prefix;//1516864397144.txt
		String fileName = s.substring(0, s.lastIndexOf(".")) + "_" + custName;
		System.out.println(fileName);
	}
}





