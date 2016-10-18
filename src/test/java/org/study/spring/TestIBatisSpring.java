package org.study.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.ibatis.User;
import org.study.spring.ibatis.UserDao;

/**
 * Created by niwei on 16/10/18.
 */
public class TestIBatisSpring {

    private ApplicationContext container;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-ibatis.xml");
    }

    /**
     * 基于 SqlSessionTemplate 查询
     */
    @Test
    public void querUserById(){
        SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate)container.getBean("sqlSessionTemplate");
        Assert.assertNotNull(sqlSessionTemplate);

        User user = sqlSessionTemplate.selectOne("org.study.spring.ibatis.User.querUserById", 1);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getUserNo());
    }

    /**
     * 基于 SqlSessionDaoSupport 查询修改
     */
    @Test
    public void sqlSessionDaoSupport(){
        UserDao userDao = (UserDao)container.getBean("userDao");
        Assert.assertNotNull(userDao);

        User param = new User();
        param.setId(1);
        param.setUserNo("MySqlSessionDaoSupport");
        userDao.updateUserNo(param);

        User user = userDao.querUserById(1);
        Assert.assertEquals(user.getUserNo(), "MySqlSessionDaoSupport");
    }
}

