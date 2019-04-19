package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @Package: com.itheima.service
 * @Author: PengSS
 * @Date: 2018/9/16 14:29
 */
public interface AccountService {
    List<Account> findAll();
}
