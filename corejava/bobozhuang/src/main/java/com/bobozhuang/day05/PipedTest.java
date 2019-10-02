package com.briup.chap10;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedTest {
	public static void main(String[] args) 
			throws IOException {
		PipedInputStream pis = 
				new PipedInputStream();
		PipedOutputStream pos = 
				new PipedOutputStream(pis);
		
		Thread t1 = new InThread(pis);
		Thread t2 = new OutThread(pos);
		t1.start();
		t2.start();
		
	}
}
class InThread extends Thread{
	PipedInputStream in;
	public InThread(PipedInputStream in){
		this.in = in;
	}
	@Override
	public void run() {
		try {
			int i = -1;
			String name = currentThread()
					.getName();
			while((i = in.read())!=-1){
				System.out.println
					(name+":"+(char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class OutThread extends Thread{
	PipedOutputStream out;
	public OutThread
		(PipedOutputStream out){
		this.out = out;
	}
	@Override
	public void run() {
		for(int i = 97; i <= 107;i++){
			try {
				Thread.sleep(1000);
				out.write(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


