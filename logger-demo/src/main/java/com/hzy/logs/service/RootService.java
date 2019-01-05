package com.hzy.logs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootService {
    private static Logger logger = LoggerFactory.getLogger("root");

    public static void  printLog(){
        logger.debug("RootService ...........this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        logger.info("RootService.............this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        logger.warn("RootService............this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        logger.error("RootService..........this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
    }
}
