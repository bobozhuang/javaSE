package main.java.com.hubery.rsamanage.encrypt.test;

import main.java.com.hubery.rsamanage.PublicKey;
import main.java.com.hubery.rsamanage.common.service.RSAInfoFactory;

/**
 * description：     从文件读取公钥
 * author Hubery
 * date 2020-09-30
 * version v0.0.1
 * since v0.0.1
 **/
public class RsaTest {
    public static void main(String[] args) throws Exception {
        //核心公钥
        PublicKey coreKey = RSAInfoFactory.getPublicKeyInstance();
        String coreKeyModulus = null;

        if (null != coreKey) {
            coreKeyModulus = coreKey.getKeyModulus();
        }
        if (null == coreKey || null == coreKeyModulus) {
            throw new Exception("exception");
        }

    }


}
