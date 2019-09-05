package com.briup.chap10;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args)
		throws Exception{
		RandomAccessFile in = 
				new RandomAccessFile
					("src/day14.txt", "r");
		in.seek(getLastPosition());
		String str = null;
		while((str=in.readLine())!=null){
			String new_str = new String(
				str.getBytes("ISO-8859-1")
					,"UTF-8");
			System.out.println(new_str);
		}
		
		long pos = in.getFilePointer();
		//System.out.println(pos);
		saveLastPosition(pos);
		in.close();
	}

	private static void saveLastPosition(long pos) 
			throws Exception {
		RandomAccessFile out = 
				new RandomAccessFile
				("src/position", "rw");
		out.writeLong(pos);
		out.close();
	}

	private static long getLastPosition() 
			throws Exception {
		// TODO Auto-generated method stub
		RandomAccessFile in = 
				new RandomAccessFile
				("src/position", "r");
		long pos = in.readLong();
		in.close();
		return pos;
	}
}
