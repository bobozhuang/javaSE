import java.io.IOException;
import java.io.InputStream;

public class MarkTest {
	public static void main(String[] args) 
			throws IOException {
		InputStream in = System.in;
		
		System.out.println
			(in.markSupported());
		
		System.out.println
			((char)in.read());
		System.out.println
			((char)in.read());
		
		in.mark(2);
		
		System.out.println
			((char)in.read());
		System.out.println
			((char)in.read());
		System.out.println
			((char)in.read());
		
		in.reset();
		
		System.out.println
			((char)in.read());
		System.out.println
			((char)in.read());
		
		in.close();
	}
}




