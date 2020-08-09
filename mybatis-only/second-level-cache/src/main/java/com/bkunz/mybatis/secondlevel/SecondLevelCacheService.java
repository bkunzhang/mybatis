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
    static RequireBillLogMapper requireBillLogMapper;

    static {
        final String resource = "mybatis/MapperConfig.xml";
        final Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession(TransactionIsolationLevel.SERIALIZABLE);
            requireBillLogMapper = session.getMapper(RequireBillLogMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public RequireBillLog getLog(int id) {
        SqlSession session = sqlSessionFactory.openSession(TransactionIsolationLevel.SERIALIZABLE);
        // todo 这里每次mapper都是新的，所以二级缓存不生效？
        RequireBillLogMapper requireBillLogMapper = session.getMapper(RequireBillLogMapper.class);
        session.commit();
        System.out.println(requireBillLogMapper);
        return requireBillLogMapper.getById(id);
    }

    public RequireBillLog getLog2(int id) {
        System.out.println(requireBillLogMapper);
        return requireBillLogMapper.getById(id);
    }
}
