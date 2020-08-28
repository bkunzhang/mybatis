package com.bkunzhang.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by bkunzhang on 2019/9/1.
 */
public class PropertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties dbProperties;
    static {
        dbProperties = getProperties("db.properties");
    }

    public static String getdbProperty(String key) {
        return dbProperties.getProperty(key);
    }

    public static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName));
            logger.debug("PropertiesUtil.class path={}", PropertiesUtil.class.getResource(".").getPath());
            logger.debug("classLoader / path={}", PropertiesUtil.class.getClassLoader().getResource("").getPath());
        } catch (Exception e) {
            logger.error("PropertiesUtil getProperties load error=", e);
        }
        return properties;
    }
}
