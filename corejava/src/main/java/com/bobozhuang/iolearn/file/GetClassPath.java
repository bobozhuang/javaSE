package main.java.com.bobozhuang.iolearn.file;

/**
 * description：
 * author Hubery
 * date 6:26 下午 2021/2/18
 * version v0.0.1
 * since v0.0.1
 **/
public class GetClassPath {

    public static void main(String[] args) {

        String path2 = Thread.currentThread().getContextClassLoader().getResource("/").getPath();

        System.out.printf("path: " + path2);
    }
}
