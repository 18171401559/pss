package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @BelongsProject: javaEE
 * @BelongsPackage: com.itheima.dao
 * @Author: PengSS
 * @CreateTime: 2018-09-13 13:33
 * @Description: ${Description}
 */
public interface RoleDao{

    List<Role> findAll();
}
