package com.hzy.logs.service.BService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BService {
    private static Logger bServiceLogger = LoggerFactory.getLogger("BService");

    public static void  printLog(){
        bServiceLogger.debug("bServiceLogger ...........this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        bServiceLogger.info("bServiceLogger.............this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        bServiceLogger.warn("bServiceLogger............this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        bServiceLogger.error("bServiceLogger..........this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
    }
}
