package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Package: com.itheima.contrallor
 * @Author: PengSS
 * @Date: 2018/9/16 14:27
 */
@Controller
public class AccountContrallor {

    @Autowired
    private AccountService accountService;

    @RequestMapping("hello")
    public String hello(Model model){
       List<Account> list=  accountService.findAll();
        model.addAttribute("list",list);
        return "success";
    }
}
