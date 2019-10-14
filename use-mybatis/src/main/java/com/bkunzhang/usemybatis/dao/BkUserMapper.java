package com.bkunzhang.usemybatis.dao;

import com.bkunzhang.usemybatis.model.BkUser;

public interface BkUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BkUser record);

    int insertSelective(BkUser record);

    BkUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BkUser record);

    int updateByPrimaryKey(BkUser record);
}