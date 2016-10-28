package org.study.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.redis.RedisOperate;

/**
 * Created by niwei on 16/10/28.
 */
public class TestRedis {

    private ApplicationContext container;

    private RedisOperate redisOperate;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-redis.xml");
        redisOperate = (RedisOperate) container.getBean("myRedisOperate");
    }

    @Test
    public void string() {
        String key = "name";
        String value = "niwei";
        redisOperate.setString(key, value);

        Assert.assertEquals(redisOperate.getString(key), value);
    }

    @Test
    public void list() {
        String listName = "niweiList";
        redisOperate.addLeftList(listName, "a");
        redisOperate.addLeftList(listName, "b");
        redisOperate.addLeftList(listName, "c");

        Assert.assertEquals(redisOperate.getLeftList(listName), "c");
        Assert.assertEquals(redisOperate.getLeftList(listName), "b");
        Assert.assertEquals(redisOperate.getLeftList(listName), "a");
    }

    @Test
    public void set() {
        String setName = "niweiSet";
        redisOperate.addSet(setName, "a");
        redisOperate.addSet(setName, "bb");
        redisOperate.addSet(setName, "ccc");

        //因为这里是无序集合,所以用isMember方法判断
        Assert.assertTrue(redisOperate.isMember(setName, "a"));
        Assert.assertTrue(redisOperate.isMember(setName, "a"));
        Assert.assertTrue(redisOperate.isMember(setName, "a"));
    }

}
