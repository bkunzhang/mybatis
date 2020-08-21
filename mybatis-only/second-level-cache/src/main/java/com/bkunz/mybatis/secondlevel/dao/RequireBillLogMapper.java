package com.bkunz.mybatis.secondlevel.dao;


import com.bkunz.mybatis.secondlevel.model.RequireBillLog;

import java.util.List;
import java.util.Map;

/**
 * @author bingkun_zhang
 * @date 2020/7/24
 */
public interface RequireBillLogMapper {
    List<RequireBillLog> findAll();
    RequireBillLog getById(int id);
    int insertList(List<RequireBillLog> list);
    int deleteBetween(Map<String, Integer> map);
}
