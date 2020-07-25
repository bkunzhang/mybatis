package com.bkunz.mybatisonly.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLogTest {
    @Test
    public void t() {
        Logger logger = LoggerFactory.getLogger("how-choose-log-class");
        logger.debug("yes");
    }
}
