package main.java.com.bobozhuang.stringDemo;

/**
 * description：
 * author Hubery
 * date 2020-04-26
 * version v0.0.1
 * since v0.0.1
 **/
public class AppversionCompare {
    public static void main(String[] args) {

        String a = "4.11.0.0";
        String app = "4.9.4";
        System.out.println(compareAppVersion(a,app));

        //转为integer
        String a1 = "1.1.1";
        String b = "1.1.12_123";

        int i1 = Integer.parseInt(a1.replace(".", "").replace("_",""));
        int i2 = Integer.parseInt(b.replace(".", "").replace("_",""));

        System.out.println(i1 > i2 ? a1 : b);


    }



    /**
     * 比较APP版本号的大小
     * <p>
     * 1、前者大则返回一个正数
     * 2、后者大返回一个负数
     * 3、相等则返回0
     *
     * @param version1 app版本号
     * @param version2 app版本号
     * @return int
     */
    public static int compareAppVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new RuntimeException("版本号不能为空");
        }
        // 注意此处为正则匹配，不能用.
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        // 取数组最小长度值
        int minLength = Math.min(versionArray1.length, versionArray2.length);
        int diff = 0;
        // 先比较长度，再比较字符

        System.out.println(versionArray1[1].compareTo(versionArray2[1]));
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {
            System.out.println(versionArray1[idx].length() - versionArray2[idx].length());
            System.out.println(versionArray1[idx].compareTo(versionArray2[idx]));
            ++idx;
        }
        // 如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }
}
