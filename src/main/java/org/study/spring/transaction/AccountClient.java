package org.study.spring.transaction;

import lombok.Data;
import org.study.spring.transaction.bean.TxAccount;
import org.study.spring.transaction.service.ITxAccountService;

/**
 * Created by niwei on 16/10/18.
 */
@Data
public class AccountClient {

    private ITxAccountService accountService;

    public TxAccount queryAccount(int id) {
        return accountService.queryTxAccount(id);
    }

    public TxAccount updateAccount(int id, long point) {
        TxAccount account = new TxAccount();
        account.setId(id);
        account.setPoint(point);
        accountService.updateTxAccount(account);

        return accountService.queryTxAccount(id);
    }
}
