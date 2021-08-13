package com.doney;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.doney.dao")
public class ManApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManApplication.class,args);
    }
}
