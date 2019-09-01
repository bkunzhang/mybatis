package com.bkunzhang.dao;

import com.bkunzhang.model.User;
import com.bkunzhang.util.JdbcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bkunzhang on 2019/9/1.
 */
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public List<User> list() {
        String sql = "SELECT id, name, age, password FROM user";
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
           connection = JdbcUtil.getConnection();
           if (connection == null) {
               logger.error("UserDao list connection is null");
               return null;
           }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("UserDao list error=", e);
        } finally {
            JdbcUtil.close(connection);
        }

        return users;
    }
}
