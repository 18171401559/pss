package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima.service
 * @Author: PengSS
 * @CreateTime: 2018-09-14 13:32
 * @Description: ${Description}
 */
public interface UserService {
    List<User> findAll();
}
