package com.bkunzhang.usemybatis.service;

import com.bkunzhang.usemybatis.dao.BkUserMapper;
import com.bkunzhang.usemybatis.model.BkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bkunzhang
 * @date 2019/10/15
 */
@Service
public class BkUserService {

    @Autowired
    private BkUserMapper bkUserMapper;

    /**
    * 批量插入
    */
    public int batchInsert(List bkUsers) {
        return bkUserMapper.batchInsert(bkUsers);
    }

    public BkUser getUserById(int userId) {
        return bkUserMapper.selectByPrimaryKey(userId);
    }

    public List<BkUser> selectByIds(List<Integer> userIds) {
        return bkUserMapper.selectByIds(userIds);
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
