package com.zjq.mybatis_learn.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * create by IT-03 on 2017/12/25
 */
public class DBAccess {

    public SqlSession getSqlSession() throws IOException{
       Reader reader =  Resources.getResourceAsReader("com/zjq/mybatis_learn/config/mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
