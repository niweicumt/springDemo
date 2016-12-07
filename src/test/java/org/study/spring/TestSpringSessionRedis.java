package org.study.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.redis.RedisOperate;

import java.util.Set;

/**
 * Created by niwei on 16/12/7.
 */
public class TestSpringSessionRedis {

    private ApplicationContext container;

    private RedisOperate redisOperate;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-redis.xml");
        redisOperate = (RedisOperate) container.getBean("myRedisOperate");
    }

    /**
     * 验证redis中存在spring:session:开头的key
     */
    @Test
    public void springSessionKeys() {
        String keys = "spring:session:*";
        Set<String> keyNames = redisOperate.keys(keys);
        Assert.assertTrue(keyNames.size() > 0);

    }

}
