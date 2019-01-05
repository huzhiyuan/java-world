package com.hzy.logs.service.A1Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A1Service {
    private static Logger a1ServiceLogger = LoggerFactory.getLogger("A1Service");

    public static void  printLog(){
        a1ServiceLogger.debug("a1ServiceLogger ...........this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        a1ServiceLogger.info("a1ServiceLogger.............this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        a1ServiceLogger.warn("a1ServiceLogger............this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
        a1ServiceLogger.error("a1ServiceLogger..........this is a test for logger but i do not know what to write so i just not stop clicking my xxxxxxxxxxx");
    }
}
