package org.study.spring.jdbc;

/**
 * Created by niwei on 16/10/17.
 */
public interface ICustomerDao {
    Customer findById(int id);

    int updateUserNo(int id, String userNo);
}
