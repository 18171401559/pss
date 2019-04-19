package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.service.UserService;

/**
 * @Package: com.itheima.service.impl
 * @Author: PengSS
 * @Date: 2018/9/16 17:05
 */

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String getName() {
        return "itcast";
    }
}
