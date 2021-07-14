package com.doney.advanced.exception;

public class AppException extends RuntimeException {

    public AppException() {
        super();
    }

    public AppException(String name){
        super(name);
    }

}
