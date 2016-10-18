package org.study.spring;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.study.spring.ibatis.User;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by niwei on 16/10/18.
 */
public class TestIBatis {

    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void setup() {
        try {
            Reader reader = Resources.getResourceAsReader("ibatis/config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            Assert.assertNotNull(sqlSessionFactory);

            sqlSession = sqlSessionFactory.openSession();
            Assert.assertNotNull(sqlSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryUserById() {
        User user = sqlSession.selectOne("org.study.spring.ibatis.User.querUserById", 1);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getUserNo());
    }

    @Test
    public void updateUserNo() {
        User param = new User();
        param.setId(1);
        param.setUserNo("testIBatisUpdate");
        sqlSession.update("org.study.spring.ibatis.User.updateUserNo", param);
        sqlSession.commit();

        User user = sqlSession.selectOne("org.study.spring.ibatis.User.querUserById", 1);
        Assert.assertEquals(user.getUserNo(), "testIBatisUpdate");
    }

}
