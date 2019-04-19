package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Package: com.itheima
 * @Author: PengSS
 * @Date: 2018/9/16 15:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ServiceTest {



    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){
        List<Account> all = accountService.findAll();
        System.out.println(all);

    }
}
