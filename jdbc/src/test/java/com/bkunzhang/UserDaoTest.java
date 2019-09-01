package com.bkunzhang;

import com.alibaba.fastjson.JSON;
import com.bkunzhang.dao.UserDao;
import com.bkunzhang.model.User;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;


/**
 * Created by bkunzhang on 2019/9/1.
 */
public class UserDaoTest {
    @Test
    public void testList() {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.list();
        System.out.println(JSON.toJSONString(userList));
        assertEquals(3, userList.size());
        assertEquals("小明", userList.get(1).getName());
    }
}
