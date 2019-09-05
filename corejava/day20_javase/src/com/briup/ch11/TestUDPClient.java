package com.briup.ch11;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TestUDPClient {
	public static void main(String args[]) throws Exception {
		long n = 1234L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);
		//准备好一个要发送的字节数组
		byte[] buf = baos.toByteArray();
		
		//创建一个UDP的socket对象来表示自己 同时指定一个端口号
		DatagramSocket ds = new DatagramSocket(9999);
		
		//把要发送的字节数组中的数据封装到数据包中(DatagramPacket),同时指明发送的目标的ip和端口号
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 5678));
		//把这个数据包从自己绑定的端口号出发出,发出到目标地址
		ds.send(dp);
		ds.close();

	}
}