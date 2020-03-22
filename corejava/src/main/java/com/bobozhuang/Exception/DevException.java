package main.java.com.bobozhuang.Exception;

public class DevException extends NestedCheckedException implements ExceptionMessage{

    private MessageSupport messageSupport = new MessageSupport();

    public DevException() {
        super("");
    }

    public DevException(String msg) {
        super(msg);
        this.messageSupport.setMessage(msg);
    }

    public DevException(String msg, Object[] args) {
        super(msg);
        this.messageSupport.setMessageKey(msg);
        this.messageSupport.setArgs(args);
    }

    public DevException(String msg, Throwable ex) {
        super(msg, ex);
        this.messageSupport.setMessageKey(msg);
    }

    public DevException(String msg, Throwable ex, Object[] args) {
        super(msg, ex);
        this.messageSupport.setMessageKey(msg);
        this.messageSupport.setArgs(args);
    }

    public DevException(Throwable ex) {
        super("", ex);
    }

    @Override
    public String getDefaultMessage() {
        return null;
    }

    @Override
    public String getMessageKey() {
        return null;
    }

    @Override
    public Object[] getArgs() {
        return new Object[0];
    }
}
