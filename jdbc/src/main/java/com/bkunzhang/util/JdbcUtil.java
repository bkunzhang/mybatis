package com.bkunzhang.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by bkunzhang on 2019/9/1.
 */
public class JdbcUtil {
    private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);

    public static Connection getConnection() {
        try {
            Class.forName(PropertiesUtil.getdbProperty("jdbc.driverClass"));
        } catch (ClassNotFoundException e) {
            logger.error("JdbcUtil getConnection Class.forName error=", e);
            return null;
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(PropertiesUtil.getdbProperty("jdbc.url"), PropertiesUtil.getdbProperty("jdbc.user"), PropertiesUtil.getdbProperty("jdbc.password"));
        } catch (SQLException e) {
            logger.error("JdbcUtil getConnection DriverManager.getConnection error=", e);
            return null;
        }
        return connection;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("JdbcUtil close error=", e);
            }
        }
    }
}
