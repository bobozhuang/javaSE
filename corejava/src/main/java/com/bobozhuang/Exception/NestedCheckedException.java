package main.java.com.bobozhuang.Exception;

/**
 * description：
 * author Hubery
 * date 2020-01-13
 * version v0.0.1
 * since v0.0.1
 **/

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class NestedCheckedException extends Exception {
    private Throwable throwable;

    public NestedCheckedException(String msg) {
        super(msg);
    }

    public NestedCheckedException(String msg, Throwable ex) {
        super(msg);
        this.throwable = ex;
    }

    public Throwable getCause() {
        return this.throwable == this ? null : this.throwable;
    }

    public String getMessage() {
        return this.throwable != null && this.throwable != this ? super.getMessage() + "; nested exception is " + this.throwable.getClass().getName() + ": " + this.throwable.getMessage() : super.getMessage();
    }

    public void printStackTrace(PrintStream ps) {
        if (this.throwable != null && this.throwable != this) {
            ps.println(this);
            this.throwable.printStackTrace(ps);
        } else {
            super.printStackTrace(ps);
        }

    }

    public void printStackTrace(PrintWriter pw) {
        if (this.throwable != null && this.throwable != this) {
            pw.println(this);
            this.throwable.printStackTrace(pw);
        } else {
            super.printStackTrace(pw);
        }

    }

    public boolean contains(Class exClass) {
        if (exClass == null) {
            return false;
        } else {
            Object ex = this;

            while(ex != null) {
                if (exClass.isInstance(ex)) {
                    return true;
                }

                if (ex instanceof NestedCheckedException) {
                    ex = ((NestedCheckedException)ex).getCause();
                } else {
                    ex = null;
                }
            }

            return false;
        }
    }
}