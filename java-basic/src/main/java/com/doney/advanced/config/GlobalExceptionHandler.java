package com.doney.advanced.config;

import org.springframework.web.bind.annotation.ExceptionHandler;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e){
        e.printStackTrace();
        return "exception!";
    }
}
