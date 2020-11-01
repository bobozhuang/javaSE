package main.java.com.bobozhuang.simpleDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class dateDemo {

    private static String pwd12341;

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
        String g = sdf.format(date);
        System.out.println(sdf);
        System.out.println(sdf.format(date));

        System.out.println(System.currentTimeMillis());

        System.out.println("------------------now:---------------");
        //使用的是UTC时间
        Instant now = Instant.now();
        System.out.println("now :" + now);

        Instant now1 = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println("now1:" + now1);
        System.out.println("------------------now:---------------");
        //Instant获取long类型的10位秒数、13位毫秒数
        Instant now2 = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println("秒数s: " + now.getEpochSecond());
        System.out.println("毫秒数:" + now.toEpochMilli());

        //LocalDateTime输出毫秒数的方式，比Instant多一步转换
        LocalDateTime localDateTime = LocalDateTime.now();
        //LocalDateTime转Instant
        Instant localDateTime2Instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println("LocalDateTime 毫秒数:" + localDateTime2Instant.toEpochMilli());

	/*	List<String> ls = new ArrayList<>();
		String[] arg = new String[] { "cmd", "dir"};
		String cmd = "cmd dir";
		Process proc = null;
		BufferedReader in = null;
		try {
			proc = Runtime.getRuntime().exec(cmd);
			in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				ls.add(line); // �����ж��Ƿ�ִ�гɹ�
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (proc != null) {
				try {
					proc.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		System.out.println(ls);
	*/
    }
}
