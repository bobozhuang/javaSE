import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class SpeedTest {
	public static void main(String[] args)
			throws Exception {
		long time_fis = readByFis();
		long time_buff = readByBuff();
		System.out.println
			("文件输入流用时:"+time_fis
				+",缓冲流用时:"+time_buff);
	}
	public static long readByFis()throws Exception{
		FileInputStream fis = 
				new FileInputStream
					("/Users/zhaojing/Downloads/迅雷下载/cn_windows_7_ultimate_with_sp1_x64_dvd_618537.iso");
		byte[] temp = new byte[64*1024];
		long l1 = System.currentTimeMillis();
		while(fis.read(temp)!=-1){
			
		}
		long l2 = System.currentTimeMillis();
		fis.close();
		return l2-l1;
	}
	public static long readByBuff()throws Exception{

		FileInputStream fis = 
				new FileInputStream
					("/Users/zhaojing/Downloads/迅雷下载/cn_windows_7_ultimate_with_sp1_x64_dvd_618537.iso");
		BufferedInputStream bis = 
				new BufferedInputStream
					(fis);
		byte[] temp = new byte[64*1024];
		long l1 = System.currentTimeMillis();
		while(bis.read(temp)!=-1){
			
		}
		long l2 = System.currentTimeMillis();
		bis.close();
		fis.close();
		return l2-l1;
	
	}
	
}
