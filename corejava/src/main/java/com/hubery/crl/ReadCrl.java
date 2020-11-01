package main.java.com.hubery.crl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.cert.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

/**
 * description：     读取证书列表
 * author Hubery
 * date 2020-03-28
 * version v0.0.1
 * since v0.0.1
 **/
public class ReadCrl {

    public static void main (String[] args) throws FileNotFoundException, CertificateException, CRLException {
        FileInputStream fis = new FileInputStream("/Users/hfhubery/Downloads/crl/SPDB.crl");


        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509CRL aCrl = (X509CRL) cf.generateCRL(fis);
        int i = 0;
        Set tSet = aCrl.getRevokedCertificates();
        Iterator tIterator = tSet.iterator();

        while (tIterator.hasNext()) {
            X509CRLEntry tEntry = (X509CRLEntry) tIterator.next();
            String sn = tEntry.getSerialNumber().toString(16).toUpperCase();
            String issName = aCrl.getIssuerDN().toString();
            String time = new SimpleDateFormat("yyyyMMddHHmmss").format (tEntry.getRevocationDate());
            i++;
            System.out.println(sn);
            System.out.println(issName);
            System.out.println(time);
            System.out.println("***************************");
        }
        System.out.println(i);
    }

}
