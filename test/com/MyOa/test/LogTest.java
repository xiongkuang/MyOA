package com.MyOa.test;

import org.junit.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * Created by xiongkuang on 3/8/16.
 */
public class LogTest {

    private Log log = LogFactory.getLog(this.getClass());
    @Test
    public void logTest() throws Exception{
        log.debug("This is debug log");
        log.info("This is info log");
        log.warn("This is warn log");
        log.error("This is error log");
        log.fatal("This is fatal log");

    }
}
