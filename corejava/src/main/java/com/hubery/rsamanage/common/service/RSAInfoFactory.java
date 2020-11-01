package main.java.com.hubery.rsamanage.common.service;

import main.java.com.hubery.rsamanage.PublicKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;


/**
 * description：
 * author Hubery
 * date 2020-09-30
 * version v0.0.1
 * since v0.0.1
 **/
public class RSAInfoFactory {

    private static final Log logger = LogFactory.getLog(RSAInfoFactory.class);
    private static PublicKey encryptorKey = new PublicKey();
    private static String keyModulusPath = "/ebank/spdb/params/netbank/pk/encryptorpubkey.rsa";

    public RSAInfoFactory() {
    }

    public static PublicKey getPublicKeyInstance() {
        if (null == encryptorKey.getKeyModulus()) {
            synchronized(encryptorKey) {
                if (null == encryptorKey.getKeyModulus()) {
                    encryptorKey.setKeyModulus(getFileContent(keyModulusPath));
                }
            }
        }

        return encryptorKey;
    }

    public static String getFileContent(String filePath) {
        File file = new File(filePath);
        LineNumberReader reader = null;
        String pk = "";

        try {
            reader = new LineNumberReader(new InputStreamReader(new FileInputStream(file)));
            pk = reader.readLine();
            if (pk == null || "".equals(pk.trim())) {
                logger.error("Cannot read public key string from resource:" + file.getName());
            }
        } catch (IOException var13) {
            var13.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException var12) {
                    var12.printStackTrace();
                }
            }

        }

        return pk;
    }

    public String getKeyModulusPath() {
        return keyModulusPath;
    }

    public void setKeyModulusPath(String keyModulusPath) {
        RSAInfoFactory.keyModulusPath = keyModulusPath;
    }
}
