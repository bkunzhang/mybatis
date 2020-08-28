package com.bkunzhang.dao;

import com.bkunzhang.util.JdbcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyDao {

    private static final Logger logger = LoggerFactory.getLogger(PropertyDao.class);

    public String getValue(String key) {
        String sql = "SELECT value FROM property where name=?";
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            if (connection == null) {
                logger.error("UserDao list connection is null");
                return null;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("value");
            }
        } catch (SQLException e) {
            logger.error("getValue error=", e);
        } finally {
            JdbcUtil.close(connection);
        }
        return null;
    }

}
