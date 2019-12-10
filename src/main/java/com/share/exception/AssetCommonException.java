package com.share.exception;

/**
 * Created by zhangxiaojun on 2017/5/27.
 */
public class AssetCommonException extends RuntimeException {


    public AssetCommonException() {
    }

    public AssetCommonException(String message) {
        super(message);
    }

    public AssetCommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssetCommonException(Throwable cause) {
        super(cause);
    }

    public AssetCommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}