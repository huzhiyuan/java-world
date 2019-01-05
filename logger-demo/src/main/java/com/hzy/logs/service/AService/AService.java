package com.hzy.logs.service.AService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AService {
    private static Logger aServiceLogger = LoggerFactory.getLogger("AService");

    public static void  printLog(){
        aServiceLogger.debug("aServiceLogger ...........this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        aServiceLogger.info("aServiceLogger.............this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        aServiceLogger.warn("aServiceLogger............this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        aServiceLogger.error("aServiceLogger..........this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
    }
}
