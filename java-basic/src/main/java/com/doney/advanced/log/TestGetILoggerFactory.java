package com.doney.advanced.log;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

public class TestGetILoggerFactory {
    public static ILoggerFactory factory = LoggerFactory.getILoggerFactory();

    public static void main(String[] args) {
        ExtendsLog extendsLog = new ExtendsLog();
        Log log = new Log();
        System.out.println(TestGetILoggerFactory.factory);

    }
}
