package com.bkunzhang.usemybatis.service;

import com.bkunzhang.model.User;
import com.bkunzhang.usemybatis.dao.BkUserMapper;
import com.bkunzhang.usemybatis.model.BkUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author bkunzhang
 * @date 2019/10/15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BkUserServiceTest {
    @Autowired
    private BkUserService bkUserService;

    @Autowired
    private BkUserMapper bkUserMapper;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getUserById() throws JsonProcessingException {

        BkUser bkUser = bkUserService.getUserById(8);
        System.out.println(mapper.writeValueAsString(bkUser));
    }

    @Test
    public void selectByIds() throws JsonProcessingException {
        List<Integer> ids = Arrays.asList(7, 8, 9, 11);
        List<BkUser> list = bkUserService.selectByIds(ids);
        assertEquals(3, list.size());
        System.out.println(mapper.writeValueAsString(list));
    }

    @Test
    public void selectByIds2() {
        List<Integer> ids = Arrays.asList(7, 8, 9, 11);
        List<BkUser> list = bkUserMapper.selectByIds2(ids);
        assertEquals(3, list.size());
    }

     /**
     * 批量插入
     */
    @Test
    public void batchInsert() {
        List<BkUser> list = Arrays.asList(new BkUser("aaa", 10, "a1"), new BkUser("bbb", 11, "a2"),
                new BkUser("ccc", 12, "a3"));
        int rs = bkUserService.batchInsert(list);
        System.out.println(rs);
        System.out.println("总行数：" + bkUserMapper.selectNums());
    }

}
