package com.jiaz.springboot.demo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private final static Logger logger = LoggerFactory.getLogger(LogTest.class);


    public static void main(String[] args) {
       logger.info("logback 成功了");
       logger.error("logback 成功了");
       logger.debug("logback 成功了");
       logger.warn("logback 成功了");
        logger.warn("logback hahaha");
        logger.warn("success");
        try {
           int i=1/0;
        }catch (Exception e){
            logger.error("hhh:{}",e.getStackTrace());
        }
   }
}
