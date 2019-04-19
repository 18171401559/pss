package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Package: com.itheima.service.impl
 * @Author: PengSS
 * @Date: 2018/9/16 14:30
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
