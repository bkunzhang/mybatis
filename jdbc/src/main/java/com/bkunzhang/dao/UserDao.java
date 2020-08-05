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

    public void rowLock() throws Exception {
        String sql = "SELECT id, name, age, password FROM user where id=2 for update";
        Connection connection = JdbcUtil.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        logger.info("do query1");
        ResultSet rs = preparedStatement.executeQuery();
        logger.info("query1 rs");
        if (rs.next()) {
            User user = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("password"));
            logger.info("query1:" + user.getName());
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    Connection connection2 = JdbcUtil.getConnection();
                    logger.info("thread start");
                    String sql2 = "SELECT id, name, age, password FROM user where id=2 for update"; // 对某一行记录加锁
//                    String sql2 = "SELECT id, name, age, password FROM user where id=3 for update";
                    connection2.setAutoCommit(false);
                    PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
                    logger.info("do query2");
                    ResultSet rs2 = preparedStatement2.executeQuery();
                    logger.info("query2 rs");
                    if (rs2.next()) {
                        User user = new User(rs2.getInt("id"), rs2.getString("name"), rs2.getInt("age"), rs2.getString("password"));
                        logger.info("query2:" + user.getName());
                    }
                    connection2.commit();
                    JdbcUtil.close(connection2);
                } catch (Exception e) {
                    logger.error("error ", e);
                }
            }
        }.start();

        Thread.sleep(10000);
        logger.info("continue, commit");
        connection.commit();
        JdbcUtil.close(connection);
    }
}
