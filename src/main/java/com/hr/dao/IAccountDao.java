package com.hr.dao;

import com.hr.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {


    Account findAccountById(Integer accountId);


    void updateAccount(Account account);


    /**
     * 根据名字查询账户
     * @param accountName
     * @return 有唯一的结果返回, 没有结果返回null, 结果超过一个抛异常
     */
    Account findAccountByName(String accountName);
}
