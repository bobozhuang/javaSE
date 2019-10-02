import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) 
		throws IOException{
		FileOutputStream fos = 
				new FileOutputStream
					("src/day14.txt",true);
		
		byte[] b = "你好中国".getBytes();
		System.out.println(b.length);
		fos.write(b);
		
		fos.flush();
		fos.close();
	}
}

