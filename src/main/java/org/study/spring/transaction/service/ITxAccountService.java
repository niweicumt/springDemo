package org.study.spring.transaction.service;

import org.study.spring.transaction.bean.TxAccount;

/**
 * Created by niwei on 16/10/18.
 */
public interface ITxAccountService {

    TxAccount queryTxAccount(int id);

    void updateTxAccount(TxAccount txAccount);

}
