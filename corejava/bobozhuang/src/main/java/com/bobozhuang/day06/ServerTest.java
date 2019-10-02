package com.briup.chap11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) {
		// 1 - 1000
		// 8080  1521 3306 
		// 16010 hbase  9000 hdfs 
		// 2080 zookeeper
		ServerSocket ss = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			ss = new ServerSocket(9999);
			//s对象不为空 代表客户端和服务端
			//成功建立连接
			// accept会造成线程阻塞
			// 含义是等待客户端连接
			
			//控制面板->程序
			// 打开或关闭windows功能
			// telnet客户端
			while(true){
				System.out.println("正在等待连接");
				Socket s = ss.accept();
				System.out.println("客户端连接成功");
				
				in = new BufferedReader(
						new InputStreamReader(
							s.getInputStream()));
				System.out.println
					("客户端传来的字符串:"
						+in.readLine());
				
				out = new PrintWriter
						(s.getOutputStream());
				out.println("你好，我是服务端~");
				out.flush();
				
				String ip = s.getInetAddress()
					.getHostAddress();
				System.out.println
					("客户端ip:"+ip);
				int c_port = s.getPort();
				System.out.println
					("客户端port:"+c_port);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null){
					out.close();
				}
				if(in != null){
					in.close();
				}
				if(ss != null){
					ss.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}



