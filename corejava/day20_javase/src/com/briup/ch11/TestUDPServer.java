package com.briup.ch11;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPServer {
	public static void main(String args[]) throws Exception {
		byte buf[] = new byte[1024];
		//创建一个UDP的socket对象来表示自己 同时指定一个端口号
		DatagramSocket ds = new DatagramSocket(5678);
		//准备好一个数据包来接收数据
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		boolean flag = true;
		while (flag) {
			//接收数据 这个方法会让线程阻塞
			ds.receive(dp);
			//数据会自动的接收到数据包dp里面封装的字节数组中buf
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bais);
			//读出字节数组中的数据
			System.out.println(dis.readLong());
		}
		if(ds!=null)ds.close();
	}
}