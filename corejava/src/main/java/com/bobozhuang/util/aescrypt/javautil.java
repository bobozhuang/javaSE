package main.java.com.bobozhuang.util.aescrypt;

import java.util.Base64;

/**
 * description：
 * author Hubery
 * date 2020-04-07
 * version v0.0.1
 * since v0.0.1
 **/
public class javautil {

    public static void main(String[] args) {
        // Base64.getDecoder();

        String decrypt = "IanoJpuRaw3buQQZfhdwnDLWqAFUJJ2qHbWZJ1IPyFA\\=";

        String dd = "ZUKj8GtklHoWHxh4dBmfrQ==";
        String decrypt1 = AESCryptoUtil.decrypt(dd);
        System.out.println(decrypt1);
    }

}


