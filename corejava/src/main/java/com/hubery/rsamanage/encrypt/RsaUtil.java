package main.java.com.hubery.rsamanage.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Random;

/**
 * description：
 * author Hubery
 * date 2020-09-30
 * version v0.0.1
 * since v0.0.1
 **/
public class RsaUtil {

    private static Random random = new Random();
    static int PRESERVED_SIZE = 12;
    static int LENGTH_SIZE = 8;
    static String CRYPT_ALG = "RC4";

    public RsaUtil() {
    }

    public static RSAPublicKey buildRSAPublicKey(String modulus, String publicExponent) {
        return buildRSAPublicKey(new BigInteger(modulus, 16), new BigInteger(publicExponent, 16));
    }

    public static RSAPublicKey buildRSAPublicKey(BigInteger modulus, BigInteger publicExponent) {
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, publicExponent);
            return (RSAPublicKey)kf.generatePublic(spec);
        } catch (Exception var4) {
            throw new IllegalStateException("cannot build public key by modulus and exponent", var4);
        }
    }

    private static byte[] reverse(byte[] raw) {
        byte[] ret = new byte[raw.length];

        for(int i = 0; i < ret.length; ++i) {
            ret[ret.length - 1 - i] = raw[i];
        }

        return ret;
    }

    static String rsaEncrypt(RSAPublicKey publicKey, String input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NOPadding");
        cipher.init(1, publicKey);
        byte[] pinBytes = cipher.doFinal(keyouAPinPadding(input, publicKey.getModulus().bitLength() / 8));
        return bytesToHexString(pinBytes);
    }

    static String encrypt(RSAPublicKey publicKey, String input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key tmpKey = generateSessionKey();
        Cipher cipherrc = Cipher.getInstance(CRYPT_ALG);
        cipherrc.init(1, tmpKey);
        updateSalt(cipherrc);
        byte[] encryptText = cipherrc.doFinal(input.getBytes());
        String txtLength = fillLength(encryptText.length, LENGTH_SIZE);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, publicKey);
        byte[] keyBytes = cipher.doFinal(tmpKey.getEncoded());
        keyBytes = reverse(keyBytes);
        String keyLength = fillLength(keyBytes.length + PRESERVED_SIZE, LENGTH_SIZE);
        byte[] keyRTCP = new byte[]{1, 2, 0, 0, 1, 104, 0, 0, 0, -92, 0, 0};
        byte[] ret = new byte[keyBytes.length + encryptText.length + keyLength.length() + txtLength.length() + PRESERVED_SIZE];
        System.arraycopy(keyLength.getBytes(), 0, ret, 0, keyLength.length());
        System.arraycopy(keyRTCP, 0, ret, keyLength.length(), PRESERVED_SIZE);
        System.arraycopy(keyBytes, 0, ret, keyLength.length() + PRESERVED_SIZE, keyBytes.length);
        System.arraycopy(txtLength.getBytes(), 0, ret, keyLength.length() + PRESERVED_SIZE + keyBytes.length, txtLength.length());
        System.arraycopy(encryptText, 0, ret, keyLength.length() + PRESERVED_SIZE + keyBytes.length + txtLength.length(), encryptText.length);
        BASE64Encoder bs = new BASE64Encoder();
        return bs.encode(ret);
    }

    static Key generateSessionKey() {
        try {
            return createKey(128, CRYPT_ALG);
        } catch (Exception var1) {
            throw new SecurityException(var1);
        }
    }

    public static Key createKey(int keySize, String algorithm) throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance(algorithm);
        kg.init(keySize, createSecureRandom());
        return kg.generateKey();
    }

    public static SecureRandom createSecureRandom() {
        SecureRandom rnd = new SecureRandom();
        rnd.setSeed(System.currentTimeMillis() + random.nextLong());
        return rnd;
    }

    static void updateSalt(Cipher c) {
        c.update(new byte[625]);
    }

    static String fillLength(int len, int size) {
        String lenStr = String.valueOf(len);
        StringBuffer buf = new StringBuffer(10);

        for(int i = 0; i < size - lenStr.length(); ++i) {
            buf.append('0');
        }

        buf.append(len);
        return buf.toString();
    }

    public static String publickeyBlobToKeyModulus(String PublickeyBlob) throws IOException {
        BASE64Decoder bs = new BASE64Decoder();
        byte[] PublickeyByte = bs.decodeBuffer(PublickeyBlob);
        byte[] PublickeyModulus = new byte[PublickeyByte.length - 20];
        System.arraycopy(PublickeyByte, 20, PublickeyModulus, 0, PublickeyByte.length - 20);
        PublickeyModulus = reverse(PublickeyModulus);
        String pwdHexString = bytesToHexString(PublickeyModulus).toUpperCase();
        return pwdHexString;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuffer stringBuilder = new StringBuffer("");
        if (src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static byte[] keyouAPinPadding(String s, int n) {
        if (n < s.length() + 2) {
            return null;
        } else {
            byte[] ba = new byte[n];
            int i = s.length() - 1;
            int len = s.length();
            if (len >= 100) {
                return null;
            } else {
                ba[0] = (byte)(48 + len / 10);
                ba[1] = (byte)(48 + len % 10);
                int j = 2;

                for(i = 0; i < len && n > 0; ba[j++] = (byte)s.charAt(i++)) {
                }

                SecureRandom rng = new SecureRandom();

                for(byte[] x = new byte[128]; j < n; ba[j++] = x[0]) {
                    x[0] = 0;

                    while(x[0] == 0) {
                        rng.nextBytes(x);
                    }
                }

                return ba;
            }
        }
    }
}
