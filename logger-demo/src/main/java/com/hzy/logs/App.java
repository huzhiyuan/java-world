package com.hzy.logs;


import com.hzy.logs.service.A1Service.A1Service;
import com.hzy.logs.service.AService.AService;
import com.hzy.logs.service.BService.BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        System.out.println("================begin test");
        for(int i=0;i<10000;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.debug("App log - 12345 上山打老虎");
            AService.printLog();
            BService.printLog();
            A1Service.printLog();
            }
    }
}
