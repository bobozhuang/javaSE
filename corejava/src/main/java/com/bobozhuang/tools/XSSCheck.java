package main.java.com.bobozhuang.tools;

import main.java.com.bobozhuang.Exception.DevException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * description：
 * author Hubery
 * date 2020-01-12
 * version v0.0.1
 * since v0.0.1
 **/
public class XSSCheck {

    Logger logger = Logger.getLogger("LoggingDemo");
    private String encoding = "GBK";
    private static final String[] REQ_DENY_PATTERN = new String[]{"<script", "javascript", "<img", "<a", "<div", "<input", "<bgsound", "<link", "<iframe", "<meta", "<body", "<style", "<object", "<xml", "<applet", "<embed", "<frameset", "<frame", "<layer", "<ilayer", "<svg", "style=", "xss:", "cookie", "alert", "document.cookie", "../"};

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String checkRequestParam(String key, String value) throws DevException {
        String escapedValue = value;

        try {
            escapedValue = URLDecoder.decode(value, this.encoding);
            StringBuilder strBuilder = new StringBuilder();

            for (int i = 0; i < escapedValue.length(); ++i) {
                char ch = escapedValue.charAt(i);
                if (ch <= '~' && ch >= ' ') {
                    strBuilder.append(ch);
                }
            }

            escapedValue = strBuilder.toString();
        } catch (UnsupportedEncodingException var7) {
            this.logger.warning("not supportted encoding:" + this.encoding + " :" + var7);

        } catch (Exception var8) {
            this.logger.warning("decode {} error" + " :" + new Object[]{value});
        }

        if (!this.isLegalString(escapedValue)) {
            throw new DevException("validation.security.antiAttack.illegalCharacter", new String[]{key});
        } else {
            return value;
        }
    }

    private boolean isLegalString(String str) {
        for (int i = 0; i < REQ_DENY_PATTERN.length; ++i) {
            if (str.toLowerCase().contains(REQ_DENY_PATTERN[i])) {
                return false;
            }
        }

        String regExp = "(.*)alert(\\s*)\\((.*)";
        if (Pattern.matches(regExp, str)) {
            return false;
        } else {
            return true;
        }
    }


}
