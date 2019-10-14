package com.bkunzhang.usemybatis.service;

import com.bkunzhang.usemybatis.dao.BkUserMapper;
import com.bkunzhang.usemybatis.model.BkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bkunzhang
 * @date 2019/10/15
 */
@Service
public class BkUserService {

    @Autowired
    private BkUserMapper bkUserMapper;

    public BkUser getUserById(int userId) {
        return bkUserMapper.selectByPrimaryKey(userId);
    }

    public boolean addUser(BkUser record){
        boolean result = false;
        try {
            bkUserMapper.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
