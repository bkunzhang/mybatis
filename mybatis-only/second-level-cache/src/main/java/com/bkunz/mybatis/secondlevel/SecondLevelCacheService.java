package com.bkunz.mybatis.secondlevel;

import com.bkunz.mybatis.secondlevel.dao.RequireBillLogMapper;
import com.bkunz.mybatis.secondlevel.model.RequireBillLog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;

@Service
public class SecondLevelCacheService {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        final String resource = "mybatis/MapperConfig.xml";
        final Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public RequireBillLog getLog(int id) {
        SqlSession session = sqlSessionFactory.openSession(TransactionIsolationLevel.SERIALIZABLE);
        RequireBillLogMapper requireBillLogMapper = session.getMapper(RequireBillLogMapper.class);
        return requireBillLogMapper.getById(id);
    }
}
