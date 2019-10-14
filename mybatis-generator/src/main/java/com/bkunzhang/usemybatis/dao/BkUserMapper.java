package com.bkunzhang.usemybatis.dao;

import com.bkunzhang.usemybatis.model.BkUser;
import java.util.List;

public interface BkUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BkUser record);

    BkUser selectByPrimaryKey(Integer id);

    List<BkUser> selectAll();

    int updateByPrimaryKey(BkUser record);
}