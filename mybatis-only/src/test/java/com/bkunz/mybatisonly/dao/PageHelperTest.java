package com.bkunz.mybatisonly.dao;

import com.alibaba.fastjson.JSON;
import com.bkunz.mybatisonly.model.RequireBillLog;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class PageHelperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setup() throws Exception {
        final String resource = "mybatis/MapperConfig.xml";
        final Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void findPage() {
        SqlSession session = sqlSessionFactory.openSession(TransactionIsolationLevel.SERIALIZABLE);
        try {
            RequireBillLogMapper requireBillLogMapper = session.getMapper(RequireBillLogMapper.class);
            PageHelper.startPage(2, 3);
            List<RequireBillLog> list = requireBillLogMapper.findAll();
            System.out.println(list.getClass().getName());
            System.out.println(list.size());
            Page<RequireBillLog> page = (Page<RequireBillLog>) list;
            System.out.println(page.getTotal());
            System.out.println(page.getOrderBy());
            System.out.println(page.getPageNum());
            System.out.println(page.getPages());

            list = requireBillLogMapper.findAll();
            System.out.println(list.getClass().getName());
            System.out.println(list.size());
        } finally {
            session.close();
        }
    }
}
