package com.doney.advanced.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ErrorHandler {

    @Bean("error")
    @Order(1)
    public ErrorHandlerView2 get2(){
        System.out.println("get2");
        return new ErrorHandlerView2();
    }

    @Bean("error")
    public ErrorHandlerView get1(){
        System.out.println("get1");
        return new ErrorHandlerView();
    }


}
