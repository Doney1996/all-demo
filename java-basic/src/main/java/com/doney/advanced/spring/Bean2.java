package com.doney.advanced.spring;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bean2 extends ApplicationObjectSupport {

    public String age = "123";

    @PostConstruct
    public  void tt(){
        Bean2 bean = getApplicationContext().getBean(Bean2.class);
    }
}
