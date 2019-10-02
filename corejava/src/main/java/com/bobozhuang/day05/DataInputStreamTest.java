import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest {
	public static void main(String[] args) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream
					(new FileInputStream
						("src/a.txt"));
			int v1 = dis.readInt();
			System.out.println(v1);
			double v2 = dis.readDouble();
			System.out.println(v2);
			char v3 = dis.readChar();
			System.out.println(v3);
			String v4 = dis.readUTF();
			System.out.println(v4);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(dis != null){
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
