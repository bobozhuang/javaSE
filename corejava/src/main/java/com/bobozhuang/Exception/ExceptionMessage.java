package main.java.com.bobozhuang.Exception;

/**
 * description：
 * author Hubery
 * date 2020-01-13
 * version v0.0.1
 * since v0.0.1
 **/
public interface ExceptionMessage {
    String getDefaultMessage();

    String getMessageKey();

    Object[] getArgs();
}
