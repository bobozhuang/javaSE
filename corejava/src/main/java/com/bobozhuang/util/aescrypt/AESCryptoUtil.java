package main.java.com.bobozhuang.util.aescrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * description：
 * author Hubery
 * date 2020-04-07
 * version v0.0.1
 * since v0.0.1
 **/
public class AESCryptoUtil {


    private static final String AES_KEY = "$MUebVF1RDB*%*a*b@vk8#P3$4c!8Hpp";
    private static final String AES_KEY_BASE64 = "ymOT1kKr19toME2WizngZg==";

    public static String encrypt(String content) {
        try {
            SecretKeySpec key = new SecretKeySpec(Base64.decode("ymOT1kKr19toME2WizngZg=="), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] byteContent = content.getBytes("gbk");
            cipher.init(1, key);
            byte[] result = cipher.doFinal(byteContent);
            return Base64.encode(result);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decrypt(String base64Content) {
        try {
            byte[] content = Base64.decode(base64Content);
            SecretKeySpec key = new SecretKeySpec(Base64.decode("ymOT1kKr19toME2WizngZg=="), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, key);
            byte[] result = cipher.doFinal(content);
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAESKeyBase64(String aesKey) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed("$MUebVF1RDB*%*a*b@vk8#P3$4c!8Hpp".getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            return Base64.encode(enCodeFormat);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        int times = 0;

        while (true) {
            times++;
            String content = "123456";
            try {
                String tip = "please input the password to encrypt:";
                if (times > 1)
                    tip = "please input the next password to encrypt (Q/q to quit):";
                System.out.println(tip);

                Scanner sc = new Scanner(System.in);
                content = sc.nextLine();
                if ("q".equals(content.trim().toLowerCase())){
                    System.exit(0);
                }

                String encrypt = encrypt(content.trim());
                System.out.println("encrypted:");
                System.out.println(encrypt);
                System.out.println("\n***************************");

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
