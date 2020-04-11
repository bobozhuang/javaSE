import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
	public static void main(String[] args) {
		Socket s = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			System.out.println
				("客户端正在准备连接服务端");
			Thread.sleep(5000);
			s = new Socket
					("127.0.0.1", 9999);
			
			out = new PrintWriter
					(s.getOutputStream());
			out.println("你好~");
			out.flush();
			
			in = new BufferedReader
				(new InputStreamReader
					(s.getInputStream()));
			System.out.println
				("服务端说:"
					+in.readLine());
			
			System.out.println
				("连接服务器成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null){
					in.close();
				}
				if(out != null){
					out.close();
				}
				if(s != null){
					s.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
