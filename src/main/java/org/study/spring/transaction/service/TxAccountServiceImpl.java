package org.study.spring.transaction.service;

import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.study.spring.transaction.bean.TxAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by niwei on 16/10/18.
 */
@Data
@Transactional
public class TxAccountServiceImpl implements ITxAccountService {

    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, timeout = 20)
    public TxAccount queryTxAccount(int id) {
        final TxAccount account = new TxAccount();
        jdbcTemplate.query("select id, point from t_account where id = " + id, new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        account.setId(rs.getInt(1));
                        account.setPoint(rs.getLong(2));
                    }
                });

        return account;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateTxAccount(final TxAccount txAccount) {
        jdbcTemplate.update("update t_account set point = ? where id = ?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, txAccount.getPoint());
                ps.setInt(2, txAccount.getId());
            }
        });
    }

}
