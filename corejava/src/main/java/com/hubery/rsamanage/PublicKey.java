package main.java.com.hubery.rsamanage;

import main.java.com.bobozhuang.util.tool.Util;
import main.java.com.hubery.rsamanage.encrypt.EncryptFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/**
 * description：
 * author Hubery
 * date 2020-09-30
 * version v0.0.1
 * since v0.0.1
 **/
public class PublicKey {


    private static final Log logger = LogFactory.getLog(PublicKey.class);
    private String keyModulus;
    private String keyBLob;

    public PublicKey() {
    }

    public String getKeyModulus() {
        return this.keyModulus;
    }

    public void setKeyModulus(String keyModulus) {
        this.keyModulus = keyModulus;
    }

    public String getKeyBLob() {
        if (Util.isNullOrEmpty(this.keyModulus)) {
            logger.error("please set keyModulus first...");
        }

        if (Util.isNullOrEmpty(this.keyBLob)) {
            EncryptFactory factory = new EncryptFactory();
            factory.setEncRSAPublicKeyModulus(this.keyModulus);

            try {
                this.keyBLob = factory.toRSAPublicKeyBlobString().replaceAll("\r|\n", "");
            } catch (IOException var3) {
                logger.error(var3);
            }
        }

        return this.keyBLob;
    }

    public void setKeyBLob(String keyBLob) {
        this.keyBLob = keyBLob;
    }
}
