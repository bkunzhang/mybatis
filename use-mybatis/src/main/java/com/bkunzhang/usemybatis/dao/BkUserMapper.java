package com.bkunzhang.usemybatis.dao;

import com.bkunzhang.usemybatis.model.BkUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BkUserMapper {
    /**
     * 批量插入
     * @param bkUsers
     * @return
     */
    int batchInsert(@Param("bkUsers") List bkUsers);

    int deleteByPrimaryKey(Integer id);

    int insert(BkUser record);

    int insertSelective(BkUser record);

    int selectNums();

    BkUser selectByPrimaryKey(Integer id);

    List<BkUser> selectByIds(@Param("ids") List<Integer> ids);

    //List<?>对象默认用list作为键，数组对象有array作为键.@Param("keyName")来设置键，设置keyName后，list,array将会失效
    List<BkUser> selectByIds2(List<Integer> ids);

    int updateByPrimaryKeySelective(BkUser record);

    int updateByPrimaryKey(BkUser record);
}