import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamTest {
	public static void main(String[] args) 
			throws IOException {
		InputStream in = System.in;
		//skip跳过的值，需要用特殊方法获得
		//in.skip();
		byte[] b = new byte[10];
		//int num = in.read(b);
		int num = in.read(b,3,4);
		System.out.println
			("读到了:"+num+"个字节");
		System.out.println
			(Arrays.toString(b));
		
		System.out.println
			("还有几个字节可以读:"+
				in.available());
		
		
		
		in.close();
	}
}
