package com.bkunzhang;

import com.bkunzhang.dao.UserDao;
import org.junit.Test;

/**
 * @author bingkun_zhang
 * @date 2020/8/5
 */
public class DbLockTest {
    public static void main(String[] args) {
        rowLock();
//        deadLock();
    }

    public static void rowLock() {
        UserDao userDao = new UserDao();
        try {
            userDao.rowLock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deadLock() {
        UserDao userDao = new UserDao();
        try {
            userDao.deadLock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
