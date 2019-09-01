package com.bkunzhang;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bkunzhang on 2019/9/1.
 */
public class LogbackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) throws ClassNotFoundException {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        //logback内部状态打印
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);
    }
}
