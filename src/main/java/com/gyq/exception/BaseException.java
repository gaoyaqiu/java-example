package com.gyq.exception;

/**
 * 异常基类.
 *
 * @auther gaoyaqiu
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public BaseException(String msg, Throwable ex) {
        super(msg, ex);
    }



    public BaseException(Throwable exception) {super(exception); }
}
