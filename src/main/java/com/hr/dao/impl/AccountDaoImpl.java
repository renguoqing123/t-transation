package com.hr.dao.impl;

import com.hr.dao.IAccountDao;
import com.hr.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Account findAccountById(Integer accountId) {
        String sql = "select * from account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return account;
    }


    public void updateAccount(Account account) {
        String sql = "update account set name=?,money=? where id=?";
        jdbcTemplate.update(sql,account.getName(),account.getMoney(),account.getId());
    }


    public Account findAccountByName(String accountName) {
        String sql = "select * from account where name = ?";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        List<Account> accounts = jdbcTemplate.query(sql,rowMapper,accountName);
        if(accounts == null || accounts.size() == 0) {
            return null;
        }
        if(accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一,数据有问题");
        }
        return accounts.get(0);


    }
}
