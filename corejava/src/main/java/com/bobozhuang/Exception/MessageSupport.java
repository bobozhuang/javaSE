package main.java.com.bobozhuang.Exception;

/**
 * description：
 * author Hubery
 * date 2020-01-13
 * version v0.0.1
 * since v0.0.1
 **/

public class MessageSupport implements ExceptionMessage {
    private String message;
    private String key;
    private Object[] args = new Object[0];

    @Override
    public String getDefaultMessage() {
        return message == null ? null : this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessageKey() {
        return key;
    }

    public void setMessageKey(String key) {
        this.key = key;
    }

    @Override
    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
