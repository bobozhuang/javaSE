package main.java.com.hubery.rsamanage.encrypt;

import com.csii.pe.encrypt.a;

import java.io.IOException;
import java.security.interfaces.RSAPublicKey;

/**
 * description：
 * author Hubery
 * date 2020-09-30
 * version v0.0.1
 * since v0.0.1
 **/
public class encryptFactroy {

    private String AppRSAPublicKeyModulus = "";
    private String EncRSAPublicKeyModulus = "";
    private String Timestamp = "";

    public encryptFactroy() {
    }

    public void setTimestamp(String timestamp) {
        this.Timestamp = timestamp;
    }

    public void publicKeyModulus(String pubKeyModulus) {
        int offset = pubKeyModulus.indexOf(58);
        if (offset < 0) {
            this.AppRSAPublicKeyModulus = pubKeyModulus;
        } else {
            this.AppRSAPublicKeyModulus = pubKeyModulus.substring(0, offset);
            this.EncRSAPublicKeyModulus = pubKeyModulus.substring(offset + 1);
        }

    }

    public void publicKeyBlob(String pubKeyBlob) throws IOException {
        int offset = pubKeyBlob.indexOf(58);
        if (offset < 0) {
            this.AppRSAPublicKeyModulus = a.publickeyBlobToKeyModulus(pubKeyBlob);
        } else {
            this.AppRSAPublicKeyModulus = a.publickeyBlobToKeyModulus(pubKeyBlob.substring(0, offset));
            this.EncRSAPublicKeyModulus = a.publickeyBlobToKeyModulus(pubKeyBlob.substring(offset + 1));
        }

    }

    private synchronized RSAPublicKey getAppPubKey() {
        String modulus = this.AppRSAPublicKeyModulus;
        String pubExponent = "10001";
        return a.buildRSAPublicKey(modulus, pubExponent);
    }

    private synchronized RSAPublicKey getEncPubKey() {
        String modulus = this.EncRSAPublicKeyModulus;
        String pubExponent = "10001";
        return a.buildRSAPublicKey(modulus, pubExponent);
    }

    public String getValue(String password) throws SecurityException {
        String plainText = this.Timestamp + ":" + password;
        RSAPublicKey AppPubKey = this.getAppPubKey();

        try {
            String encryptText = RsaUtil.encrypt(AppPubKey, plainText);
            return encryptText;
        } catch (Exception var5) {
            throw new SecurityException("encrypt password error.", var5);
        }
    }

    public String getPinValue(String password) throws SecurityException {
        RSAPublicKey AppPubKey = this.getAppPubKey();
        RSAPublicKey EncPubKey = this.getEncPubKey();

        try {
            String pin = RsaUtil.rsaEncrypt(EncPubKey, password);
            String plainText = this.Timestamp + ":" + pin;
            String encryptText = RsaUtil.encrypt(AppPubKey, plainText);
            return encryptText;
        } catch (Exception var7) {
            throw new SecurityException("encrypt password error.", var7);
        }
    }
}
