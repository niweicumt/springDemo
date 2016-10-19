package org.study.spring.mvc.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;
import org.study.spring.mvc.bean.MvcUser;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by niwei on 16/10/19.
 */
@Data
@Component
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MvcUser queryUser(int id) {
        final MvcUser user = new MvcUser();
        jdbcTemplate.query("select id, user_no as userNo from t_user where id = " + id, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setId(rs.getInt(1));
                user.setUserNo(rs.getString(2));
            }
        });

        return user;
    }
}
