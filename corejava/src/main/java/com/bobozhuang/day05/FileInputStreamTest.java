import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) 
			throws IOException {
		//  \\
		// /User/zhaojing/....
		// D:\\....\\
		FileInputStream fis = 
				new FileInputStream
					("./src/com/briup/chap10/day14.txt");
		byte[] b = new byte[30];
		while(fis.read(b)!=-1){
			System.out.println
				(new String(b));
		}
		
		fis.close();
	}
}
