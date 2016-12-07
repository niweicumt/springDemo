package org.study.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by niwei on 16/10/28.
 */
public class RedisOperate {
    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> template;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setOperations;

    /**
     * 字符串设值
     *
     * @param key
     * @param value
     */
    public void setString(String key, String value) {
        valueOperations.set(key, value);
    }

    /**
     * 获取字符串的值
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return valueOperations.get(key);
    }

    /**
     * 在list中保存元素,从左边开始
     *
     * @param key   列表名
     * @param value
     */
    public void addLeftList(String key, String value) {
        listOperations.leftPush(key, value);
    }

    /**
     * 获取list中元素,从左边开始
     *
     * @param key
     * @return
     */
    public String getLeftList(String key) {
        return listOperations.leftPop(key);
    }

    /**
     * 在set中保存元素
     *
     * @param key
     * @param value
     */
    public void addSet(String key, String value) {
        setOperations.add(key, value);
    }

    /**
     * 按名称模糊查询key
     *
     * @param keyName
     * @return
     */
    public Set<String> keys(String keyName) {
        Set<String> result = new HashSet<String>();

        Set<byte[]> keys = template.getConnectionFactory().getConnection().keys(keyName.getBytes());
        if (keys != null && keys.size() > 0) {
            Iterator<byte[]> it = keys.iterator();

            while (it.hasNext()) {
                byte[] data = it.next();
                result.add(new String(data, 0, data.length));
            }
        }
        return result;
    }

    /**
     * 判断是否是set中的元素
     *
     * @param key
     * @param value
     * @return
     */
    public boolean isMember(String key, String value) {
        return setOperations.isMember(key, value);
    }
}
