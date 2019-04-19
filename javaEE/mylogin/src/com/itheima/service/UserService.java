package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domian.User;

import java.sql.SQLException;

/**
 * @Package: com.itheima.service
 * @Author: PengSS
 * @Date: 2018/9/26 15:07
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public User login(User user) throws SQLException {
        return userDao.login(user);
    }
}
