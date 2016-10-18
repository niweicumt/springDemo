package org.study.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.AccessException;
import org.study.spring.transaction.AccountClient;
import org.study.spring.transaction.bean.TxAccount;
import org.study.spring.transaction.service.ITxAccountService;

/**
 * Created by niwei on 16/10/18.
 */
public class TestTransaction {

    private ApplicationContext container;

    private ITxAccountService accountService;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("application-transaction.xml");

        accountService = (ITxAccountService)container.getBean("accountService");
    }

    @Test
    public void queryTxAccount(){
        TxAccount account = accountService.queryTxAccount(1);
        Assert.assertNotNull(account);
    }

    @Test
    public void updateTxAccount(){
        int accountId = 1;
        TxAccount updateAccount = new TxAccount();
        updateAccount.setId(accountId);
        updateAccount.setPoint(250L);
        accountService.updateTxAccount(updateAccount);

        TxAccount account = accountService.queryTxAccount(accountId);
        Assert.assertEquals(250, account.getPoint().intValue());
    }

    @Test
    public void accountClient(){
        AccountClient accountClient = (AccountClient)container.getBean("accountClient");

        TxAccount account = accountClient.queryAccount(1);

        Assert.assertNotNull(account);
        Assert.assertEquals(account.getId(), 1);

        account = accountClient.updateAccount(1, 1024);
        Assert.assertEquals(account.getPoint().intValue(), 1024);
    }
}
