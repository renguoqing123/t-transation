package com.hr.service;

import com.hr.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {


    Account findAccountById(Integer accountId);


    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
