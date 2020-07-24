package com.bkunz.mybatisonly.dao;

import com.bkunz.mybatisonly.model.RequireBillLog;

import java.util.List;

/**
 * @author bingkun_zhang
 * @date 2020/7/24
 */
public interface RequireBillLogMapper {
    List<RequireBillLog> findAll();
}
