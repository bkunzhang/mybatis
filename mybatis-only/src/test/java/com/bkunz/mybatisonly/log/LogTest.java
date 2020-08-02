package com.bkunz.mybatisonly.log;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogTest {
    @Test
    public void shouldUseSlf4j() {
//        LogFactory.useSlf4jLogging();
        Log log = LogFactory.getLog(Object.class);
        logSomething(log);
        assertEquals(log.getClass().getName(), Slf4jImpl.class.getName());

    }

    private void logSomething(Log log) {
        log.warn("Warning message.");
        log.debug("Debug message.");
        log.error("Error message.");
//        log.error("Error with Exception.", new Exception("Test exception."));
    }
}
