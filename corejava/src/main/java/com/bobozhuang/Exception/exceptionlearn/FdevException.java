package main.java.com.bobozhuang.Exception.exceptionlearn;

/**
 * description：
 * author Hubery
 * date 2020-10-03
 * version v0.0.1
 * since v0.0.1
 **/
public class FdevException extends RuntimeException {
    private String code;
    private String message;
    private Object[] args;

    public FdevException(String code) {
        this.code = code;
    }

    public FdevException(String code, Object[] args) {
        this.code = code;
        this.args = args;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
