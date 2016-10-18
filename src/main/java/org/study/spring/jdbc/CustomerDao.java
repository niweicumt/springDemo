package org.study.spring.jdbc;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by niwei on 16/10/17.
 */
public class CustomerDao extends JdbcDaoSupport implements ICustomerDao{

    public Customer findById(int id) {
        return getJdbcTemplate().queryForObject("select id, user_no from t_user where id = " + id, new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setUserNo(rs.getString(2));
                return customer;
            }
        });
    }

    public int updateUserNo(final int id, final String userNo) {
        return getJdbcTemplate().update("update t_user set user_no = ? where id = ? ", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, userNo);
                ps.setInt(2, id);
            }
        });
    }
}
