package com.mumu.demo.common;

/**
 * @program: springBootDemo
 * @description: 服务异常类
 * @author: mumu
 * @create: 2021-03-28 18:44
 **/
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceException(final String message, Throwable th){
        super(message,th);
        this.message = message;
    }

    public ServiceException(final String message){
        this.message = message;
    }

    public static void throwEx(String message){
        throw new ServiceException(message);
    }
}
