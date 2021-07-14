package com.doney.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author ODC-ODL
 */
public class ExtendsLog extends Log {
    Logger logger = LoggerFactory.getLogger(ExtendsLog.class);
    public void printLog(){
        logger.debug("good");
    }
}
