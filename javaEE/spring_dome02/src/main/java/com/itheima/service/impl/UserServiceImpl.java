package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima.service.impl
 * @Author: PengSS
 * @CreateTime: 2018-09-14 13:32
 * @Description: ${Description}
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 查询所有用户的方法
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }
}
