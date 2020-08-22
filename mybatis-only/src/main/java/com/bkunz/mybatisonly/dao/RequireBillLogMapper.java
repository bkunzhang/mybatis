package com.bkunz.mybatisonly.dao;

import com.bkunz.mybatisonly.model.RequireBillLog;

import java.util.List;
import java.util.Map;

/**
 * @author bingkun_zhang
 * @date 2020/7/24
 */
public interface RequireBillLogMapper {
    List<RequireBillLog> findAll();
    int update(RequireBillLog log);
    int insertList(List<RequireBillLog> list);
    int insert(RequireBillLog log);
    int deleteBetween(Map<String, Integer> map);
}
