package com.doney.advanced.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author ODC-ODL
 */
public class ExtendsLog extends Log {
    public static Logger logger = LoggerFactory.getLogger(ExtendsLog.class);
    public void printLog(){
        logger.info("this is good");
    }

    public static void main(String[] args) {
        ExtendsLog extendsLog = new ExtendsLog();
        extendsLog.printLog();
        //
    }
}
