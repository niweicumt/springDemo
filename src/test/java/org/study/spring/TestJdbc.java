package org.study.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.study.spring.jdbc.Customer;
import org.study.spring.jdbc.CustomerDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by niwei on 16/10/17.
 */
public class TestJdbc {

    private ApplicationContext container;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-jdbc.xml");

        jdbcTemplate = (JdbcTemplate) container.getBean("jdbcTemplate");
    }

    @Test
    public void getJdbcTemplate() {
        Assert.assertNotNull(jdbcTemplate);
    }

    @Test
    public void querySingle() {
        Map<String, Object> map = jdbcTemplate.queryForMap("select id, user_no from t_user where id = (select max(id) from t_user)");
        Assert.assertNotNull(map);
        Assert.assertNotNull(map.get("id"));
    }

    @Test
    public void queryList() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select id, user_no from t_user limit 10");
        Assert.assertNotNull(list);
        Assert.assertEquals(10, list.size());

        List<Customer> list2 = jdbcTemplate.query("select id, user_no from t_user limit 10", new ResultSetExtractor<List<Customer>>() {
            public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Customer> customerList = new ArrayList<Customer>();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt(1));
                    customer.setUserNo(rs.getString(2));

                    customerList.add(customer);
                }
                return customerList;
            }
        });
        Assert.assertNotNull(list2);
        Assert.assertEquals(10, list2.size());
        Assert.assertTrue(list2.get(0) instanceof Customer);

        List<Customer> list3 = jdbcTemplate.query("select id, user_no from t_user limit 10", new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setUserNo(rs.getString(2));
                return customer;
            }
        });
        Assert.assertNotNull(list3);
        Assert.assertEquals(10, list3.size());
        Assert.assertTrue(list3.get(0) instanceof Customer);
    }

    @Test
    public void update() {
        int affectRows = jdbcTemplate.update("update t_user set user_no = ? where id = ?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, "niwei");
                ps.setInt(2, 1);
            }
        });

        Assert.assertEquals(affectRows, 1);
    }

    @Test
    public void testJdbcDaoSupport() {
        int id = 1;
        String userNo = "niwei-test";
        CustomerDao customerDao = (CustomerDao) container.getBean("customerDao");
        int rows = customerDao.updateUserNo(id, userNo);
        Assert.assertEquals(rows, 1);

        Customer customer = customerDao.findById(id);
        Assert.assertEquals(customer.getUserNo(), userNo);
    }
}
