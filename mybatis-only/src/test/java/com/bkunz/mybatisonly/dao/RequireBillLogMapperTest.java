package com.bkunz.mybatisonly.dao;

import com.alibaba.fastjson.JSON;
import com.bkunz.mybatisonly.model.RequireBillLog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author bingkun_zhang
 * @date 2020/7/24
 */
public class RequireBillLogMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setup() throws Exception {
        final String resource = "mybatis/MapperConfig.xml";
        final Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
    @Test
    public void findAll() {
        SqlSession session = sqlSessionFactory.openSession(TransactionIsolationLevel.SERIALIZABLE);
        try {
            List<RequireBillLog> list = session.selectList("com.bkunz.mybatisonly.dao.RequireBillLogMapper.findAll");
            System.out.println(JSON.toJSONString(list));
        } finally {
            session.close();
        }
    }
}
