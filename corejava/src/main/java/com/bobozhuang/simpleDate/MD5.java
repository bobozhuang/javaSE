package main.java.com.bobozhuang.simpleDate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	public static String encoder(String salt, String psd) {
		try {
			StringBuffer sb = new StringBuffer();
			//1.指定加密算法
			MessageDigest digest = MessageDigest.getInstance("MD5");
			//2.将需要加密的字符串转换为byte，然后哈西算�?
			byte[] bs = digest.digest((salt + psd).getBytes());
			//3.遍历，让其生�?32位字符串，固定写�?
			for(byte b : bs) {
				int i = b & 0xff;
				String hexString = Integer.toHexString(i);
				if(hexString.length() < 2) {
					hexString = "0" +hexString;
				}
				
				sb.append(hexString);
 			}
			return sb.toString();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		String s1 = MD5.encoder("test_header", "test_header");
		String s2 = MD5.encoder("laowang", "laowang");
		String s3 = MD5.encoder("admin", "admin");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
	}

}
