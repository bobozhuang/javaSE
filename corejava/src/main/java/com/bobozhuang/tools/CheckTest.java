package main.java.com.bobozhuang.tools;

import main.java.com.bobozhuang.Exception.DevException;

/**
 * description：
 * author Hubery
 * date 2020-01-13
 * version v0.0.1
 * since v0.0.1
 **/
public class CheckTest {
    public static void main(String[] args) {
        XSSCheck xssCheck = new XSSCheck();
        try {
            String xss = xssCheck.checkRequestParam("xss", "<scipt");
        } catch (DevException e) {
            e.printStackTrace();
        }


    }
}
