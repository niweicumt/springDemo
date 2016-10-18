package org.study.spring.ibatis;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by niwei on 16/10/18.
 */
public class UserDao extends SqlSessionDaoSupport {

    public User querUserById(int id) {
        return getSqlSession().selectOne("org.study.spring.ibatis.User.querUserById", 1);
    }

    public void updateUserNo(User user) {
        getSqlSession().update("org.study.spring.ibatis.User.updateUserNo", user);
    }
}
