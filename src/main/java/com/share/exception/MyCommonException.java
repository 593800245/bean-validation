package com.share.exception;

/**
 * @author guozhe
 */
public class MyCommonException extends RuntimeException {


    public MyCommonException() {
    }

    public MyCommonException(String message) {
        super(message);
    }

    public MyCommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCommonException(Throwable cause) {
        super(cause);
    }

    public MyCommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}